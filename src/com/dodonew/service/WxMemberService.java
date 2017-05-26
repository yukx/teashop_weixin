package com.dodonew.service;

import com.dodonew.model.WxMember;
import com.dodonew.model.Wx_MemberCard;
import com.dodonew.utils.ResponseType;

import java.util.Map;

/**
 * Created by maxiao on 2017/5/5.
 */
public interface WxMemberService {


    ResponseType<WxMember,Map<String,Object>> selectByPrimaryKey(int memberId );
}
