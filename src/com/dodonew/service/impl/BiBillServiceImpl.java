package com.dodonew.service.impl;

import com.dodonew.dao.BiBillMapper;
import com.dodonew.dao.Bi_EzItemMapper;
import com.dodonew.dao.WxPayOrderInfoMapper;
import com.dodonew.model.BiBill;
import com.dodonew.model.Bi_EzItem;
import com.dodonew.model.WxPayOrderInfo;
import com.dodonew.service.BiBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maxiao on 2017/5/4.
 */

@Service("biBillService")
public class BiBillServiceImpl implements BiBillService {

    @Autowired
    BiBillMapper biBillMapper;
    @Autowired
    Bi_EzItemMapper biEzItemMapper;
    @Autowired
    WxPayOrderInfoMapper wxPayOrderInfoMapper;



    @Override
    @Transactional
    public void save(BiBill bill, List<Bi_EzItem> ezItem, WxPayOrderInfo wxPayOrderInfo) {

        biBillMapper.insertSelective(bill);
        wxPayOrderInfoMapper.insert(wxPayOrderInfo);
        for (Bi_EzItem item:
             ezItem) {

            biEzItemMapper.insertSelective(item);
        }
    }
}
