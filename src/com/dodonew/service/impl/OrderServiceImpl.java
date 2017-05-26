package com.dodonew.service.impl;

import com.dodonew.dao.*;
import com.dodonew.entityVo.*;
import com.dodonew.model.*;
import com.dodonew.service.OrderService;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.WxUtils;
import jvc.util.DBUtils;
import jvc.util.DateUtils;
import jvc.util.StringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by yukx on 17/4/22.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    WxPayOrderInfoMapper wxPayOrderInfoMapper;

    /*@Autowired
    BiBillItemMapper biBillItemMapper;*/

    @Autowired
    Bi_EzItemMapper biEzItemMapper;

    @Autowired
    WxMemberMapper wxMemberMapper;

    @Autowired
    WxRechargeRuleMapper wxRechargeRuleMapper;

    @Autowired
    WxMemberConsumeMapper wxMemberConsumeMapper;


    @Override
    public WxPayOrderInfo queryOrder(String orderId) {
        return wxPayOrderInfoMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 查询订单信息1
     *
     * @param decodeVo
     * @return
     */
    @Override
    public OrderInfoVo queryOrder(DecodeVo decodeVo) {

        WxMemberKey wxMemberKey = new WxMemberKey();
        wxMemberKey.setStoreId(decodeVo.getStoreId());
        wxMemberKey.setUnionId(decodeVo.getUnionId());

        OrderInfoVo infoVo = new OrderInfoVo();

        // 查询商家会员折扣
        String discount = wxMemberMapper.getMemberDiscount(wxMemberKey);
        DecimalFormat df = new DecimalFormat("#.##");
        double dis = 1;
        if (StringUtils.isNotBlank(discount)) {
            dis = Double.parseDouble(discount);
            if (dis > 1 && dis < 10) {      // 大于1的折扣都是不规范的
                dis /= 10;
            } else if (dis >= 10) {
                dis = 0;
            }
            infoVo.setSJMember(true);
            infoVo.setJsDiscount(dis);
        } else {
            infoVo.setFinalPayAmount(Double.parseDouble(df.format(decodeVo.getPayAmount() * 0.01)));
        }


        List<Bi_EzItem> ezItems = biEzItemMapper.selectByOrderId(decodeVo.getOrderId());
        double disMoney = 0;      // 参与打折的商品总金额
        if (dis != 1 && ezItems != null && ezItems.size() > 0) {
            for (Bi_EzItem item : ezItems) {
                if (item.getDiscountPercent() < 1) {
                    continue;
                }
                if (item.getIsDiscount() == 1) {
                    disMoney += item.getPrice().doubleValue() * item.getGoodsNum();
                    continue;
                }
            }
        }

        if (dis != 1) {
            double disAmount = (1 - dis) * disMoney;        // 打折金额
            double finalAmount = decodeVo.getPayAmount() * 0.01;
            if (finalAmount > disAmount) {
                finalAmount -= disAmount;          // 折扣金额
            }
            infoVo.setFinalPayAmount(Double.parseDouble(df.format(finalAmount)));
            infoVo.setSjDisAmount(Double.parseDouble(df.format(disAmount)));
        }

        infoVo.setPayAmount(Double.parseDouble(df.format(decodeVo.getPayAmount() * 0.01)));
        infoVo.setStoreId(decodeVo.getStoreId());
        infoVo.setOrderId(decodeVo.getOrderId());
        /*try {
            // 查询好旺会员
            JSONObject userInfo = AESUtil.decrypt(decodeVo.getSession_key(), decodeVo.getEncryptedData(), decodeVo.getIv());
            if (userInfo != null && userInfo.has("unionId")) {
                wxMemberKey.setOpenId(null);
                wxMemberKey.setUnionId(userInfo.getString("unionId"));

            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }*/

        BiBillItemKey biBillItemKey = new BiBillItemKey();
        biBillItemKey.setStoreid(decodeVo.getStoreId());
        biBillItemKey.setBillid(decodeVo.getOrderId());

        infoVo.setEzItemList(ezItems);
        return infoVo;
    }

    /**
     * 查询订单信息2
     *
     * @param payInfoVo
     * @return
     */
    @Override
    public PayInfoVo queryOrder(PayInfoVo payInfoVo) {

        WxMemberKey wxMemberKey = new WxMemberKey();
        wxMemberKey.setStoreId(payInfoVo.getStoreId());
        //wxMemberKey.setOpenId(payInfoVo.getOpenId());
        wxMemberKey.setUnionId(payInfoVo.getUnionId());

        WxMember wxMember = wxMemberMapper.queryByOpenId(wxMemberKey);

        if (wxMember != null) {
            payInfoVo.setMember(true);
            payInfoVo.setMemberId(wxMember.getMemberid());

            double balance = wxMember.getBalance();
            double payAmount = payInfoVo.getPayAmount();
            if (balance >= payAmount) {      // 可以全额支付
                payInfoVo.setPayAll(true);
            }

            payInfoVo.setBalance(wxMember.getBalance());

            // 查询充值规则   统一用分进行计算
            WxRechargeRule wxRechargeRule = new WxRechargeRule();
            wxRechargeRule.setStoreid(payInfoVo.getStoreId());
            wxRechargeRule.setBalance((int) (balance * 100));
            wxRechargeRule.setPayAmount((int) (payAmount * 100));
            payInfoVo.setRuleList(wxRechargeRuleMapper.queryPayRule(wxRechargeRule));
        }

        return payInfoVo;
    }

    /**
     * 会员卡支付
     *
     * @param cardPayVo
     * @return
     */
    @Override
    @Transactional
    public Integer cardPay(CardPayVo cardPayVo) throws Exception {

        WxMember wxMember = wxMemberMapper.selectByPrimaryKey(cardPayVo.getMemberId());
        if (wxMember == null) {
            return ErrorEnum.MEMBER_ISNULL.getCode();
        }
        double balance = wxMember.getBalance();
        if (balance < cardPayVo.getPayAmount()) {
            return ErrorEnum.BALANCE_NOT_ENOUGH.getCode();
        }

        WxPayOrderInfo wxPayOrderInfo = new WxPayOrderInfo();
        wxPayOrderInfo.setOrderid(cardPayVo.getOrderId());
        wxPayOrderInfo.setRealpayamount((int) (cardPayVo.getPayAmount() * 100));
        wxPayOrderInfo.setFavAmount((int) (cardPayVo.getPayAmount() * 100));
        wxPayOrderInfo.setOpenid(cardPayVo.getOpenId());
        wxPayOrderInfo.setFormId(cardPayVo.getFormId());
        wxPayOrderInfo.setPayway(3);
        wxPayOrderInfo.setMemberid(cardPayVo.getMemberId() + "");
        wxPayOrderInfo.setStatus(1);        // 修改订单成功
        int a = wxPayOrderInfoMapper.updateByPrimaryKeySelective(wxPayOrderInfo);

        // 修改会员余额
        int b = wxMemberMapper.updateBalanceByKey(cardPayVo);

        balance -= cardPayVo.getPayAmount();
        DecimalFormat df = new DecimalFormat("#.##");

        // 保存消费记录
        WxMemberConsume wxMemberConsume = new WxMemberConsume();
        wxMemberConsume.setMemberid(cardPayVo.getMemberId());
        wxMemberConsume.setOrderid(cardPayVo.getOrderId());
        wxMemberConsume.setConsumemoney(cardPayVo.getPayAmount());
        wxMemberConsume.setConsumetype(0);  // 扣费
        wxMemberConsume.setCreatetime(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
        wxMemberConsume.setLastbalance(Double.parseDouble(df.format(balance)));
        wxMemberConsume.setStoreid(cardPayVo.getStoreId());
        int c = wxMemberConsumeMapper.insertSelective(wxMemberConsume);     // 序列号自增  返回的主键在wxMemberConsume对象里面

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("会员卡支付异常");
        }

        // 模版消息
        if (StringUtils.isNotBlank(cardPayVo.getOpenId()) && StringUtils.isNotBlank(cardPayVo.getFormId())) {
            String access_token = WxUtils.getAccess_token();

            SendModelVo sendModelVo = new SendModelVo();
            sendModelVo.setForm_id(cardPayVo.getFormId());
            sendModelVo.setTouser(cardPayVo.getOpenId());
            sendModelVo.setTemplate_id(WxUtils.NXFTZ_MODEL);

            JSONObject object = new JSONObject();
            object.put("keyword1", WxUtils.newJSONDATA(cardPayVo.getStoreName(), null));        // 商家名称
            object.put("keyword2", WxUtils.newJSONDATA(cardPayVo.getOrderId(), null));          // 订单编号
            object.put("keyword3", WxUtils.newJSONDATA(df.format(cardPayVo.getOrderAmount() * 0.01), null));    // 订单金额
            object.put("keyword4", WxUtils.newJSONDATA(df.format(cardPayVo.getPayAmount()), null));      // 支付金额
            object.put("keyword5", WxUtils.newJSONDATA("会员卡支付", null));
            object.put("keyword6", WxUtils.newJSONDATA(DateUtils.now("yyyy-MM-dd HH:mm:ss"), null));
            object.put("keyword7", WxUtils.newJSONDATA("会员消费" + df.format(cardPayVo.getPayAmount()) + "元,余额" + df.format(balance) + "元", null));

            sendModelVo.setData(object);

            String rs = WxUtils.sendModel(access_token, sendModelVo);
            logger.info("会员消费模版通知:" + rs);
        }

        return ErrorEnum.SUC.getCode();
    }

    @Override
    @Transactional
    public void callBack(NotifyVo notifyVo) throws Exception {
        String orderId = notifyVo.getPartnerOrderId();

        WxPayOrderInfo wxPayOrderInfo = new WxPayOrderInfo();
        wxPayOrderInfo.setOrderid(orderId);
        wxPayOrderInfo.setTransactionId(notifyVo.getDdnorderId());
        wxPayOrderInfo.setStatus(1);
        int a = wxPayOrderInfoMapper.updateByPrimaryKeySelective(wxPayOrderInfo);
        if (a <= 0) {
            return;
        }

        wxPayOrderInfo = wxPayOrderInfoMapper.selectByPrimaryKey(orderId);
        if (wxPayOrderInfo == null) {
            return;
        }

        DecimalFormat df = new DecimalFormat("#.##");

        Integer fanAmount = wxPayOrderInfo.getFavAmount();  // 折扣款金额(分)
        JSONObject data = new JSONObject();
        data.put("keyword5", WxUtils.newJSONDATA("微信支付", null));
        data.put("keyword7", WxUtils.newJSONDATA("微信消费" + df.format(fanAmount * 0.01) + "", null));
        if (StringUtils.isNotBlank(wxPayOrderInfo.getRechargeid()) && StringUtils.isNotBlank(wxPayOrderInfo.getMemberid())) {
            Integer memberId = Integer.parseInt(wxPayOrderInfo.getMemberid());
            Integer rechargeId = Integer.parseInt(wxPayOrderInfo.getRechargeid());
            if (memberId > 0 && rechargeId > 0) {
                WxRechargeRule wxRechargeRule = wxRechargeRuleMapper.selectByPrimaryKey(rechargeId);
                if (wxRechargeRule == null) {
                    return;
                }
                WxMember wxMember = wxMemberMapper.selectByPrimaryKey(memberId);
                if (wxMember == null) {
                    return;
                }

                double balance = wxMember.getBalance();     // 会员余额/元
                int rechargeNum = wxRechargeRule.getRechargenum();      // 充值金额/分
                double giveNum = wxRechargeRule.getGivenumber();        // 赠送金额/元

                double zjBalace = balance + rechargeNum * 0.01 + giveNum;       // 充值后的金额
                balance = zjBalace - fanAmount * 0.01;        // 会员余额=充值后的金额-实付款金额

                data.put("keyword5", WxUtils.newJSONDATA("会员卡支付", null));
                String msg = "您充值" + df.format(rechargeNum * 0.01) + "元,赠送" + df.format(giveNum) + "元, 支付" + df.format(fanAmount * 0.01) + "元,余额"+df.format(balance);
                data.put("keyword7", WxUtils.newJSONDATA(msg, null));

                logger.info("会员余额:" + balance);

                wxMember.setBalance(Double.parseDouble(df.format(balance)));
                int b = wxMemberMapper.updateByPrimaryKeySelective(wxMember);

                wxPayOrderInfo.setPayway(3);        // 修改支付方式为微信支付
                int e = wxPayOrderInfoMapper.updateByPrimaryKeySelective(wxPayOrderInfo);

                // 保存充值记录
                WxMemberConsume wxMemberConsume = new WxMemberConsume();
                wxMemberConsume.setMemberid(memberId);
                wxMemberConsume.setOrderid(orderId);
                wxMemberConsume.setConsumemoney(Double.parseDouble(df.format(rechargeNum * 0.01)));
                wxMemberConsume.setGivemoney(Double.parseDouble(df.format(giveNum)));
                wxMemberConsume.setConsumetype(1);  // 充值
                wxMemberConsume.setCreatetime(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
                wxMemberConsume.setLastbalance(Double.parseDouble(df.format(zjBalace)));
                wxMemberConsume.setRemark("充值" + Double.parseDouble(df.format(rechargeNum * 0.01)) + "元,赠送" + Double.parseDouble(df.format(giveNum)) + "元");
                wxMemberConsume.setStoreid(wxPayOrderInfo.getStoreid());
                int d = wxMemberConsumeMapper.insertSelective(wxMemberConsume);

                // 保存消费记录
                wxMemberConsume = new WxMemberConsume();
                wxMemberConsume.setMemberid(memberId);
                wxMemberConsume.setOrderid(orderId);
                wxMemberConsume.setConsumemoney(Double.parseDouble(df.format(fanAmount * 0.01)));
                wxMemberConsume.setConsumetype(0);  // 扣费
                wxMemberConsume.setCreatetime(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
                wxMemberConsume.setLastbalance(Double.parseDouble(df.format(balance)));
                wxMemberConsume.setStoreid(wxPayOrderInfo.getStoreid());
                int c = wxMemberConsumeMapper.insertSelective(wxMemberConsume);

                if (b <= 0 || c <= 0 || d <= 0 || e <= 0) {
                    throw new Exception("充值赠送记录修改失败");
                }
            }
        }
        if (StringUtils.isNotBlank(wxPayOrderInfo.getOpenid()) && StringUtils.isNotBlank(wxPayOrderInfo.getFormId())) {
            String access_token = WxUtils.getAccess_token();

            SendModelVo sendModelVo = new SendModelVo();
            sendModelVo.setForm_id(wxPayOrderInfo.getFormId());
            sendModelVo.setTouser(wxPayOrderInfo.getOpenid());
            sendModelVo.setTemplate_id(WxUtils.NXFTZ_MODEL);

            data.put("keyword1", WxUtils.newJSONDATA(wxPayOrderInfo.getStorename(), null));
            data.put("keyword2", WxUtils.newJSONDATA(orderId, null));
            data.put("keyword3", WxUtils.newJSONDATA(df.format(wxPayOrderInfo.getPayamount() * 0.01), null));
            data.put("keyword4", WxUtils.newJSONDATA(df.format(wxPayOrderInfo.getFavAmount() * 0.01), null));
            data.put("keyword6", WxUtils.newJSONDATA(DateUtils.now("yyyy-MM-dd HH:mm:ss"), null));

            sendModelVo.setData(data);

            String rs = WxUtils.sendModel(access_token, sendModelVo);
            logger.info("会员消费模版通知:" + rs);
        }
        logger.info("回调成功");
    }

    @Override
    public int updateOrder(WxPayOrderInfo wxPayOrderInfo) {
        return wxPayOrderInfoMapper.updateByPrimaryKeySelective(wxPayOrderInfo);
    }

    public static void main(String[] args) {

        /*System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.20")));  //输出false
        System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0); //输出true

        System.out.println(new BigDecimal(1.2).equals(new BigDecimal("1.20"))); //输出是?
        System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal("1.20")) == 0); //输出是?

        System.out.println(new BigDecimal(1.2).equals(new BigDecimal(1.20))); //输出是?*/
        System.out.println(new BigDecimal(1).compareTo(new BigDecimal(2)));//输出是?
    }
}
