package com.dodonew.dao;

import com.dodonew.model.SE_Store;

public interface SE_StoreMapper {
    int deleteByPrimaryKey(String storeId);

    int insert(SE_Store record);

    int insertSelective(SE_Store record);

    SE_Store selectByPrimaryKey(String storeId);

    int updateByPrimaryKeySelective(SE_Store record);

    int updateByPrimaryKeyWithBLOBs(SE_Store record);

    int updateByPrimaryKey(SE_Store record);
}