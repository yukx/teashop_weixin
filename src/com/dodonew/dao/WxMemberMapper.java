package com.dodonew.dao;

import com.dodonew.entityVo.CardPayVo;
import com.dodonew.model.WxMember;
import com.dodonew.model.WxMemberKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wxMemberMapper")
public interface WxMemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(WxMember record);

    int insertSelective(WxMember record);

    WxMember selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(WxMember record);

    int updateByPrimaryKey(WxMember record);

    WxMember queryByOpenId(WxMemberKey key);

    List<WxMember> query(WxMember record);

    String getMemberDiscount(WxMemberKey key);

    int updateBalanceByKey(CardPayVo cardPayVo);

    Integer selectCardId(String storeId);
}