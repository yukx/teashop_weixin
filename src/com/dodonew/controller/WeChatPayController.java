package com.dodonew.controller;

import com.dodonew.entityVo.*;
import com.dodonew.model.WxPayOrderInfo;
import com.dodonew.service.OrderService;
import com.dodonew.utils.*;
import jvc.util.CacheUtils;
import jvc.util.StringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yukx on 17/4/21.
 */
@Controller
@RequestMapping("/wxChatPay")
public class WeChatPayController {
    Logger logger = Logger.getLogger(WeChatPayController.class);

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/check")
    @ResponseBody
    public String check(@ModelAttribute checkVo checkVo) {
        String[] tmpArr = {checkVo.getToken(), checkVo.getTimestamp(), checkVo.getNonce()};
        String mySignature = EncodeUtil.SHA1Encode(SortUtil.dictiondrySort(tmpArr));
        if (checkVo.getSignature().equals(mySignature)) {
            logger.info("-------------- 微信服务器验证成功 ---------------");
            return checkVo.getEchostr();
        }
        return "";
    }

    @RequestMapping(value = "/scanOrder")
    public String scanOrder(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        int code = 0;
        if (StringUtils.isBlank(orderId)) {
            request.setAttribute("note", "订单为空");
            return "error";
        }
        String head = request.getHeader("user-agent");
        if (head.indexOf(HttpUtil.ISZFB) == -1) {
            request.setAttribute("note", "请使用支付宝打开");
            return "error";
        }
        DoPayVo doPayVo = new DoPayVo();
        WxPayOrderInfo wxPayOrderInfo = orderService.queryOrder(orderId);
        int code1 = 0;
        if (wxPayOrderInfo == null) {
            request.setAttribute("note", "订单为空");
            return "error";
        }
        if (wxPayOrderInfo.getStatus() == 1) {
            request.setAttribute("note", "订单已支付");
            return "error";
        }
        if (wxPayOrderInfo.getStatus() == 10) {
            request.setAttribute("note", "订单已作废");
            return "error";
        }

        String notify_url = "www.baidu.com";        // 测试

        doPayVo.setAmount(wxPayOrderInfo.getPayamount());
        doPayVo.setBody(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setStoreId(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setRemark(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setPayType("ZFB");
        doPayVo.setNotify_url(notify_url);

        JSONObject object = DdnPayUtil.unifiedorder(doPayVo);
        if (object != null && object.has("payurl") && StringUtils.isNotBlank(object.getString("payurl"))) {
            return "redirect:" + object.getString("payurl");
        }
        request.setAttribute("note", (object != null && object.has("errmsg")) ? object.getString("errmsg") : "下单失败");
        return "error";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody String code) {
        System.out.println(code);
        JSONObject object = WxUtils.jscode2session(code);
        logger.info("----------[jscode2session]:" + object);
        int error_code = 0;
        if (object == null) {
            error_code = ErrorEnum.WXCHAT_ERROR.getCode();
            return ResultUtil.errorJson(error_code, ErrorEnum.getMsg(error_code));
        }
        if (object.has("errcode")) {
            error_code = ErrorEnum.WXCHAT_ERROR.getCode();
            return ResultUtil.errorJson(error_code, ErrorEnum.getMsg(error_code));
        }
        String session_key = object.getString("session_key");
        String openid = object.getString("openid");
        long expires_in = object.getLong("expires_in");     // 有效时长  秒

        // 获取key
        String session = ExecLinuxCMDUtil.instance.exec("cat /dev/urandom |od -x | tr -d ' '| head -n 1").toString();

        CacheUtils.put(session, session_key + "," + openid, (expires_in - 60) * 1000);      // 缓存以毫秒为单位, 提前一分钟算作废

        JSONObject result = new JSONObject();
        result.put("session", session);
        result.put("openId", openid);

        error_code = ErrorEnum.SUC.getCode();
        return ResultUtil.resultJson(error_code, ErrorEnum.getMsg(error_code), result);
    }


    @ResponseBody
    @RequestMapping(value = "/decodeUserInfo")
    public String decodeUserInfo(@ModelAttribute DecodeVo decodeVo) {
        int code = 0;
        if (decodeVo.getEncryptedData() == null || decodeVo.getIv() == null || decodeVo.getSession() == null) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        String sessionValue = CacheUtils.getString(decodeVo.getSession());
        if (StringUtils.isBlank(sessionValue)) {
            code = ErrorEnum.SESSION_NULL_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        String session_key = sessionValue.split(",")[0];
        try {
            JSONObject userInfo = AESUtil.decrypt(session_key, decodeVo.getEncryptedData(), decodeVo.getIv());
            code = ErrorEnum.SUC.getCode();
            return ResultUtil.resultJson(code, ErrorEnum.getMsg(code), userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/payInfo", produces = "text/json;charset=UTF-8")
    public String payInfo(PayInfoVo payInfoVo) {
        int code = 0;
        if (StringUtils.isBlank(payInfoVo.getOrderId()) || payInfoVo.getPayAmount() <= 0) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }

        WxPayOrderInfo wxPayOrderInfo = orderService.queryOrder(payInfoVo.getOrderId());
        String code1 = WxUtils.checkOrder(wxPayOrderInfo);
        if (code1 != null) return code1;

        payInfoVo.setStoreId(wxPayOrderInfo.getStoreid());
        payInfoVo.setStoreName(wxPayOrderInfo.getStorename());

        orderService.queryOrder(payInfoVo);

        code = ErrorEnum.SUC.getCode();
        return ResultUtil.resultJson(code, ErrorEnum.getMsg(code), JSONObject.fromObject(payInfoVo));
    }

    @ResponseBody
    @RequestMapping(value = "/cardPay")
    public String cardPay(@ModelAttribute CardPayVo cardPayVo) throws Exception {
        int code = 0;
        if (cardPayVo.getMemberId() <= 0 || StringUtils.isBlank(cardPayVo.getOrderId()) || cardPayVo.getPayAmount() <= 0) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        // 验证订单
        WxPayOrderInfo wxPayOrderInfo = orderService.queryOrder(cardPayVo.getOrderId());
        String code1 = WxUtils.checkOrder(wxPayOrderInfo);
        if (code1 != null) return code1;

        cardPayVo.setOrderAmount(wxPayOrderInfo.getPayamount());
        cardPayVo.setStoreId(wxPayOrderInfo.getStoreid());
        cardPayVo.setStoreName(wxPayOrderInfo.getStorename());

        code = orderService.cardPay(cardPayVo);
        return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
    }


    @ResponseBody
    @RequestMapping(value = "/wxPay")
    public String doPay(@ModelAttribute DoPayVo doPayVo) {
        int code = 0;
        if (StringUtils.isBlank(doPayVo.getOrderId()) || doPayVo.getPayAmount() <= 0
                || StringUtils.isBlank(doPayVo.getPayOpenId())) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }

        WxPayOrderInfo wxPayOrderInfo = orderService.queryOrder(doPayVo.getOrderId());
        String code1 = WxUtils.checkOrder(wxPayOrderInfo);
        if (code1 != null) return code1;

        if (StringUtils.isNotBlank(doPayVo.getPayOpenId()) || doPayVo.getMemberId() > 0) {
            wxPayOrderInfo.setRechargeid(doPayVo.getRechargeid() + "");
            wxPayOrderInfo.setOpenid(doPayVo.getPayOpenId());
            wxPayOrderInfo.setMemberid(doPayVo.getMemberId() + "");
            wxPayOrderInfo.setFormId(doPayVo.getFormId());
            orderService.updateOrder(wxPayOrderInfo);
        }

        // 修改实付金额
        wxPayOrderInfo.setRealpayamount((int) (doPayVo.getPayAmount() * 100));
        wxPayOrderInfo.setFavAmount((int) (doPayVo.getFavMoney() * 100));
        orderService.updateOrder(wxPayOrderInfo);

        doPayVo.setAmount((int) (doPayVo.getPayAmount() * 100));
        doPayVo.setBody(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setStoreId(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setRemark(wxPayOrderInfo.getStoreid() + "");
        doPayVo.setPayType("WXXCX");

        JSONObject object = DdnPayUtil.unifiedorder(doPayVo);
        code = ErrorEnum.SUC.getCode();
        return ResultUtil.resultJson(code, ErrorEnum.getMsg(code), object);
    }

}
