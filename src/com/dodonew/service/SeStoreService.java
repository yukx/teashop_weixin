package com.dodonew.service;

import com.dodonew.model.SE_Store;

/**
 * Created by maxiao on 2017/5/12.
 */
public interface SeStoreService {


    SE_Store selectByPrimaryKey(String storeId);
}
