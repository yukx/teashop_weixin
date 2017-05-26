package com.dodonew.dao;

import com.dodonew.entityVo.CardPayVo;
import com.dodonew.model.WxPayOrderInfo;
import org.springframework.stereotype.Repository;

@Repository("wxPayOrderInfoMapper")
public interface WxPayOrderInfoMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(WxPayOrderInfo record);

    int insertSelective(WxPayOrderInfo record);

    WxPayOrderInfo selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(WxPayOrderInfo record);

    int updateByPrimaryKey(WxPayOrderInfo record);

    int updateRealMoney(CardPayVo cardPayVo);
}