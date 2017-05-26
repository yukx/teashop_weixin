package com.dodonew.service;

import com.dodonew.model.Pv_User;

/**
 * Created by maxiao on 2017/5/5.
 */
public interface PvUserService {

    Pv_User selectByPrimaryKey(String storeId,String userId);

}
