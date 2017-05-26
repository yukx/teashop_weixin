package com.dodonew.service.impl;

import com.dodonew.dao.WxMemberMapper;
import com.dodonew.dao.Wx_MemberCardMapper;
import com.dodonew.model.WxMember;
import com.dodonew.model.Wx_MemberCardKey;
import com.dodonew.service.WxMemberService;
import com.dodonew.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maxiao on 2017/5/5.
 */
@Service("wxMemberService")
public class WxMemberServiceImpl implements WxMemberService {

    @Autowired
    WxMemberMapper wxMemberMapper;

    @Override
    public ResponseType<WxMember, Map<String, Object>> selectByPrimaryKey(int memberId) {

        WxMember member = wxMemberMapper.selectByPrimaryKey(memberId);
        ResponseType<WxMember, Map<String, Object>>  responseType = null;
        if(member == null)return responseType;

        responseType.entity = member;
        Map<String,Object> res = new HashMap<String,Object>();//以后添加附加信息
        responseType.extra = res;
        return  responseType;
    }

}
