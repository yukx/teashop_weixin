package com.dodonew.controller;

import com.dodonew.controller.helper.BiBillHelper;
import com.dodonew.entityVo.DecodeVo;
import com.dodonew.entityVo.NotifyVo;
import com.dodonew.entityVo.OrderInfoVo;
import com.dodonew.model.BiBillItem;
import com.dodonew.model.BiBillItemKey;
import com.dodonew.model.WxPayOrderInfo;
import com.dodonew.service.OrderService;
import com.dodonew.utils.DdnPayUtil;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.ResultUtil;
import com.dodonew.utils.WxUtils;
import jvc.util.CacheUtils;
import jvc.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yukx on 17/4/22.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/queryOrder", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String queryOrder(@ModelAttribute DecodeVo decodeVo) {
        int code = 0;
        if (decodeVo == null || decodeVo.getUnionId() == null ||
                decodeVo.getOpenId() == null || decodeVo.getOrderId() == null) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }

        String orderId = decodeVo.getOrderId();

        String cacheUnionId = CacheUtils.getString(decodeVo.getOrderId() + "_unionId");
        if (StringUtils.isNotBlank(cacheUnionId) && !cacheUnionId.equalsIgnoreCase(decodeVo.getUnionId())) {
            code = ErrorEnum.ORDER_REDPAY.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        } else if (StringUtils.isBlank(cacheUnionId)) {
            CacheUtils.put(decodeVo.getOrderId() + "_unionId", decodeVo.getUnionId(), 1000 * 20);       // 设置20秒  防止同时被多人扫
        }

        WxPayOrderInfo wxPayOrderInfo = orderService.queryOrder(orderId);
        String code1 = WxUtils.checkOrder(wxPayOrderInfo);
        if (code1 != null) return code1;

        /*if (StringUtils.isNotBlank(wxPayOrderInfo.getOpenid()) && DdnPayUtil.checkOrderStatus(wxPayOrderInfo.getStoreid(), orderId)){
            code = ErrorEnum.ORDER_ISPAY.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }*/
        decodeVo.setStoreId(wxPayOrderInfo.getStoreid() + "");
        decodeVo.setPayAmount(wxPayOrderInfo.getPayamount());

        if (StringUtils.isBlank(wxPayOrderInfo.getOpenid())) {
            wxPayOrderInfo.setOpenid(decodeVo.getOpenId());
            orderService.updateOrder(wxPayOrderInfo);
        }

        OrderInfoVo infoVo = orderService.queryOrder(decodeVo);
        if (infoVo != null) {
            infoVo.setStoreName(wxPayOrderInfo.getStorename());
        }

        code = ErrorEnum.SUC.getCode();
        return ResultUtil.resultJson(code, ErrorEnum.getMsg(code), JSONObject.fromObject(infoVo));
    }

    @ResponseBody
    @RequestMapping(value = "/notify")
    public String notifyBlck(@ModelAttribute NotifyVo notifyVo) throws Exception {
        if (notifyVo.getDdnorderId() == null || notifyVo.getPartnerOrderId() == null
                || notifyVo.getSign() == null || notifyVo.getTime() == null || notifyVo.getTransationId() == null) {
            logger.error("支付回调参数为空");
            return "ERROR";
        }

        if (DdnPayUtil.callBackCheck(notifyVo)) {
            logger.info("支付回调验证成功");

            orderService.callBack(notifyVo);
            //通知收银台
            BiBillHelper.triggerEve(notifyVo.getPartnerOrderId());
            return "SUCCESS";
        } else {
            logger.info("支付回调验证失败");
            return "ERROR";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/queryOrderRule", produces = "text/json;charset=UTF-8")
    public String queryOrderRule() {

        return "";
    }

}
