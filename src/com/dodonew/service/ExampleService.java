package com.dodonew.service;

import com.dodonew.model.WxMember;
import com.dodonew.pageUtil.PagedResult;

/**
 * Created by yukx on 17/4/11.
 */
public interface ExampleService {

    PagedResult<WxMember> queryByPage(WxMember wxMember);
}
