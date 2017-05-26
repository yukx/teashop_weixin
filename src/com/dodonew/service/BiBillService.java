package com.dodonew.service;

import com.dodonew.model.BiBill;
import com.dodonew.model.Bi_EzItem;
import com.dodonew.model.WxPayOrderInfo;

import java.util.List;

/**
 * Created by maxiao on 2017/5/4.
 */
public interface BiBillService {

    void save(BiBill bill, List<Bi_EzItem> ezItem, WxPayOrderInfo wxPayOrderInfo);
}
