package com.dodonew.dao;

import com.dodonew.model.Wx_MemberCard;
import com.dodonew.model.Wx_MemberCardKey;

public interface Wx_MemberCardMapper {
    int deleteByPrimaryKey(Wx_MemberCardKey key);

    int insert(Wx_MemberCard record);

    int insertSelective(Wx_MemberCard record);

    Wx_MemberCard selectByPrimaryKey(Wx_MemberCardKey key);

    int updateByPrimaryKeySelective(Wx_MemberCard record);

    int updateByPrimaryKey(Wx_MemberCard record);
}