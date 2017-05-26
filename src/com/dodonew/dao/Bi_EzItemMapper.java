package com.dodonew.dao;

import com.dodonew.model.Bi_EzItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("biEzItemMapper")
public interface Bi_EzItemMapper {
    int deleteByPrimaryKey(Integer ezItemId);

    int insert(Bi_EzItem record);

    int insertSelective(Bi_EzItem record);

    Bi_EzItem selectByPrimaryKey(Integer ezItemId);

    int updateByPrimaryKeySelective(Bi_EzItem record);

    int updateByPrimaryKey(Bi_EzItem record);

    List<Bi_EzItem> selectByOrderId(String orderId);
}