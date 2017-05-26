package com.dodonew.controller;

import com.dodonew.controller.helper.BackMapHelper;
import com.dodonew.entityVo.BiBillVo;
import com.dodonew.model.*;
import com.dodonew.service.*;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.Mutils;
import com.dodonew.utils.ResponseType;
import jvc.util.DBUtils;
import jvc.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by maxiao on 2017/5/4.
 */
@RestController
@RequestMapping("BiBill")
public class BiBillController {

    @Autowired
    EzGoodsCustomerService ezGoodsCustomerService;

    @Autowired
    WxMemberService wxMemberService;
    @Autowired
    PvUserService pvUserService;
    @Autowired
    BiBillService biBillService;
    @Autowired
    DdSubjectTypeService ddSubjectTypeService;

    @Autowired
    SeStoreService seStoreService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody BiBillVo biBillVo){

        if(biBillVo.getGoods()==null||biBillVo.getGoods().size() == 0 ){
            return BackMapHelper.back(ErrorEnum.PARAM_ERROR);
        }

        String billId = Mutils.getBillId(biBillVo.getStoreId());
        BiBill biBill = new BiBill();
        biBill.setStoreid(StringUtils.toInt(biBillVo.getStoreId()));
        biBill.setBillid(billId);

        if(StringUtils.isNotBlank(biBillVo.getMemberId())){
            //设置会员信息
            ResponseType<WxMember,Map<String,Object>> wxMember =
                    wxMemberService.selectByPrimaryKey(StringUtils.toInt(biBillVo.getMemberId()));
            if(wxMember == null) return  BackMapHelper.back(ErrorEnum.MEMBER_ISNULL);
            biBill.setMemberid(biBillVo.getMemberId());
            biBill.setMembercardid(wxMember.entity.getCardid());
            biBill.setMembername(wxMember.entity.getMembername());
        }
        //设置负责人
        if(StringUtils.isNotBlank(biBillVo.getChargePersonId())){
            Pv_User pvUser =  pvUserService.selectByPrimaryKey(biBillVo.getStoreId(),biBillVo.getChargePersonId());
            if(pvUser == null) return  BackMapHelper.back(ErrorEnum.PV_USER_NULL);
            biBill.setChargeperson(pvUser.getUserName());
            biBill.setChargepersonid(biBillVo.getChargePersonId());
        }
        //设置收银员
        if(StringUtils.isNotBlank(biBillVo.getCheckOutPersonId())){
            Pv_User pvUser =  pvUserService.selectByPrimaryKey(biBillVo.getStoreId(),biBillVo.getCheckOutPersonId());
            if(pvUser == null) return  BackMapHelper.back(ErrorEnum.PV_USER_NULL);
            biBill.setCheckoutperson(pvUser.getUserName());
            biBill.setChargepersonid(biBillVo.getCheckOutPersonId());
        }
        //验证 门店信息
        SE_Store seStore = seStoreService.selectByPrimaryKey(biBillVo.getStoreId());
        if(seStore == null) return  BackMapHelper.back(ErrorEnum.SE_STORE_NULL);


        //设置支付方式
        Dd_SubjectType ddSubjectType = ddSubjectTypeService.selectByPrimaryKey(biBillVo.getSubjectID());
        if(ddSubjectType == null) return  BackMapHelper.back(ErrorEnum.SUBJECT_TYPE_NULL);
        biBill.setSubjectid(ddSubjectType.getSubjectID());
        biBill.setSubjectname(ddSubjectType.getSubjectName());

        biBill.setSumfordiscount(biBillVo.getSumForDiscount());
        biBill.setSumofconsume( biBillVo.getSumOfConsume());
        biBill.setSumtopay(biBillVo.getSumToPay());
        biBill.setSumpaid(biBillVo.getSumPaid());
        biBill.setReducemantissa((float) biBillVo.getReduceMantissa());

        biBill.setCheckoutnull(false);
        biBill.setIsarchived(false);
        biBill.setIsuploaded(false);
        biBill.setIsdeleted(false);
        biBill.setBillfrom(1);
        biBill.setIscheckouting(1);
        biBill.setCreatetime(new Date());

        WxPayOrderInfo wxPayOrderInfo = new WxPayOrderInfo();
        wxPayOrderInfo.setBillid(billId);
        wxPayOrderInfo.setOrderid(billId);
        wxPayOrderInfo.setPayamount((int)(biBillVo.getSumPaid()*100));
        wxPayOrderInfo.setStorename(seStore.getStoreName());


        List<Bi_EzItem> item = new ArrayList<Bi_EzItem>();//设置商品
        for(int i = 0 ; i < biBillVo.getGoods().size(); i ++){
            Map<String,String> temp = biBillVo.getGoods().get(i);
            ResponseType<EZ_GoodsCustomer,EZ_GoodsSpecCustomer> responseType =
                ezGoodsCustomerService.selectBySpecCustomerId(StringUtils.toLong(temp.get("specCustomerId")));
            if(responseType == null){
                return  BackMapHelper.back(ErrorEnum.NO_DATA);
            }

            Bi_EzItem biEzItem = new Bi_EzItem();
            int itemId = DBUtils.getSerialNo("bi_EzItem");
            biEzItem.setEzItemId(itemId);
            biEzItem.setBillId(billId);
            biEzItem.setStoreId(biBillVo.getStoreId());
            biEzItem.setSpecCustomerId( StringUtils.toLong( temp.get("specCustomerId")));
            biEzItem.setDiscountMoney( StringUtils.toDouble(temp.get("discountMoney")));
            biEzItem.setDiscountPercent(StringUtils.toDouble((temp.get("discountPercent"))));
            biEzItem.setGoodsCustomerId(responseType.entity.getGoodsCustomerId());
            biEzItem.setGoodsId(responseType.entity.getGoodsId());
            biEzItem.setGoodsName(responseType.entity.getGoodsName());
            biEzItem.setGoodsCode(responseType.extra.getGoodsCode());
            biEzItem.setPrice( responseType.extra.getPrice());
            biEzItem.setGoodsSpec(responseType.extra.getGoodsSpec());
            biEzItem.setEngName(responseType.entity.getEngName());
            biEzItem.setGoodsNum( StringUtils.toInt( temp.get("goodsNum")));
            biEzItem.setIsCoupon(responseType.entity.getIsCoupon());
            biEzItem.setIsDiscount(responseType.entity.getIsDiscount());
            biEzItem.setItemRemark(temp.get("itemRemark"));
            item.add(biEzItem);
        }

        biBillService.save(biBill,item,wxPayOrderInfo);

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("url","https://www.howang.com.cn/haowangPay_api/wxChatPay/scanOrder.do?orderId="+billId);
        data.put("billId",billId);

        return  BackMapHelper.backData(data);

    }

}
