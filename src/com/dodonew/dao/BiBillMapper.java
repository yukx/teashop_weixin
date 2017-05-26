package com.dodonew.dao;

import com.dodonew.model.BiBill;
import com.dodonew.model.BiBillKey;
import org.springframework.stereotype.Repository;

@Repository("biBillMapper")
public interface BiBillMapper {
    int deleteByPrimaryKey(BiBillKey key);

    int insert(BiBill record);

    int insertSelective(BiBill record);

    BiBill selectByPrimaryKey(BiBillKey key);

    int updateByPrimaryKeySelective(BiBill record);

    int updateByPrimaryKey(BiBill record);
}