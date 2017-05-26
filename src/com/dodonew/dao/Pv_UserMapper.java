package com.dodonew.dao;

import com.dodonew.model.Pv_User;
import com.dodonew.model.Pv_UserKey;

public interface Pv_UserMapper {
    int deleteByPrimaryKey(Pv_UserKey key);

    int insert(Pv_User record);

    int insertSelective(Pv_User record);

    Pv_User selectByPrimaryKey(Pv_UserKey key);

    int updateByPrimaryKeySelective(Pv_User record);

    int updateByPrimaryKey(Pv_User record);
}