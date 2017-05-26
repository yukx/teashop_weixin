package com.dodonew.dao;

import com.dodonew.model.EZ_GoodsSpecCustomer;

public interface EZ_GoodsSpecCustomerMapper {
    int deleteByPrimaryKey(Long specCustomerId);

    int insert(EZ_GoodsSpecCustomer record);

    int insertSelective(EZ_GoodsSpecCustomer record);

    EZ_GoodsSpecCustomer selectByPrimaryKey(Long specCustomerId);

    int updateByPrimaryKeySelective(EZ_GoodsSpecCustomer record);

    int updateByPrimaryKey(EZ_GoodsSpecCustomer record);
}