package com.dodonew.service.impl;

import com.dodonew.dao.Dd_SubjectTypeMapper;
import com.dodonew.model.Dd_SubjectType;
import com.dodonew.service.DdSubjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maxiao on 2017/5/12.
 */
@Service("ddSubjectTypeService")
public class DdSubjectTypeServiceImpl implements DdSubjectTypeService {

    @Autowired
    Dd_SubjectTypeMapper ddSubjectTypeMapper;
    @Override
    public Dd_SubjectType selectByPrimaryKey(String subjectID) {
        return ddSubjectTypeMapper.selectByPrimaryKey(subjectID);
    }
}
