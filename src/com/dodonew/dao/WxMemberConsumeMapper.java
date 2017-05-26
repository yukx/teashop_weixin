package com.dodonew.dao;

import com.dodonew.model.WxMemberConsume;
import org.springframework.stereotype.Repository;

@Repository("wxMemberConsumeMapper")
public interface WxMemberConsumeMapper {
    int deleteByPrimaryKey(Integer serialno);

    int insert(WxMemberConsume record);

    int insertSelective(WxMemberConsume record);

    WxMemberConsume selectByPrimaryKey(Integer serialno);

    int updateByPrimaryKeySelective(WxMemberConsume record);

    int updateByPrimaryKey(WxMemberConsume record);
}