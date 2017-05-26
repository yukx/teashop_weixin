package com.dodonew.dao;

import com.dodonew.model.BiBillItem;
import com.dodonew.model.BiBillItemKey;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("biBillItemMapper")
public interface BiBillItemMapper {
    int deleteByPrimaryKey(BiBillItemKey key);

    int insert(BiBillItem record);

    int insertSelective(BiBillItem record);

    BiBillItem selectByPrimaryKey(BiBillItemKey key);

    int updateByPrimaryKeySelective(BiBillItem record);

    int updateByPrimaryKey(BiBillItem record);

    List<BiBillItem> listBillItem(BiBillItemKey key);
}