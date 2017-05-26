package com.dodonew.dao;

import com.dodonew.model.WxRechargeRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wxRechargeRuleMapper")
public interface WxRechargeRuleMapper {
    int deleteByPrimaryKey(Integer rechargeid);

    int insert(WxRechargeRule record);

    int insertSelective(WxRechargeRule record);

    WxRechargeRule selectByPrimaryKey(Integer rechargeid);

    int updateByPrimaryKeySelective(WxRechargeRule record);

    int updateByPrimaryKey(WxRechargeRule record);

    List<WxRechargeRule> queryPayRule(WxRechargeRule wxRechargeRule);
}