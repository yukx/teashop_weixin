package com.dodonew.service.impl;

import com.dodonew.dao.SE_StoreMapper;
import com.dodonew.model.SE_Store;
import com.dodonew.service.SeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maxiao on 2017/5/12.
 */
@Service("seStoreService")
public class SeStoreServiceImpl  implements SeStoreService{

    @Autowired
    SE_StoreMapper seStoreMapper;

    @Override
    public SE_Store selectByPrimaryKey(String storeId) {
        return seStoreMapper.selectByPrimaryKey(storeId);
    }
}
