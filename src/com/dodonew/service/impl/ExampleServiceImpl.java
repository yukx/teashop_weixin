package com.dodonew.service.impl;

import com.dodonew.dao.WxMemberMapper;
import com.dodonew.model.WxMember;
import com.dodonew.pageUtil.BeanUtil;
import com.dodonew.pageUtil.PagedResult;
import com.dodonew.service.ExampleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yukx on 17/4/11.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    WxMemberMapper wxMemberMapper;

    @Override
    public PagedResult<WxMember> queryByPage(WxMember wxMember) {
        if(wxMember.getPageNo() != 0 && wxMember.getPageSize() != 0){
            PageHelper.startPage(wxMember.getPageNo(), wxMember.getPageSize());
        }
        return BeanUtil.toPagedResult(wxMemberMapper.query(wxMember));
    }
}
