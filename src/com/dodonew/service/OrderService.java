package com.dodonew.service;

import com.dodonew.entityVo.*;
import com.dodonew.model.BiBillItem;
import com.dodonew.model.BiBillItemKey;
import com.dodonew.model.WxPayOrderInfo;

import java.util.List;

/**
 * Created by yukx on 17/4/22.
 */
public interface OrderService {

    WxPayOrderInfo queryOrder(String orderId);

    OrderInfoVo queryOrder(DecodeVo decodeVo);

    PayInfoVo queryOrder(PayInfoVo payInfoVo);

    Integer cardPay(CardPayVo cardPayVo) throws Exception;

    void callBack(NotifyVo notifyVo) throws Exception;

    int updateOrder(WxPayOrderInfo wxPayOrderInfo);
}
