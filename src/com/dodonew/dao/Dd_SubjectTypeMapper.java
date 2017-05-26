package com.dodonew.dao;

import com.dodonew.model.Dd_SubjectType;

public interface Dd_SubjectTypeMapper {
    int deleteByPrimaryKey(String subjectID);

    int insert(Dd_SubjectType record);

    int insertSelective(Dd_SubjectType record);

    Dd_SubjectType selectByPrimaryKey(String subjectID);

    int updateByPrimaryKeySelective(Dd_SubjectType record);

    int updateByPrimaryKey(Dd_SubjectType record);
}