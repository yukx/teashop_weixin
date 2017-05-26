package com.dodonew.dao;

import com.dodonew.model.EZ_GoodsCustomer;

public interface EZ_GoodsCustomerMapper {
    int deleteByPrimaryKey(Long goodsCustomerId);

    int insert(EZ_GoodsCustomer record);

    int insertSelective(EZ_GoodsCustomer record);

    EZ_GoodsCustomer selectByPrimaryKey(Long goodsCustomerId);

    int updateByPrimaryKeySelective(EZ_GoodsCustomer record);

    int updateByPrimaryKey(EZ_GoodsCustomer record);
}