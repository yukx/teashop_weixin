package com.dodonew.service.impl;

import com.dodonew.dao.Pv_UserMapper;
import com.dodonew.model.Pv_User;
import com.dodonew.model.Pv_UserKey;
import com.dodonew.service.PvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maxiao on 2017/5/5.
 */
@Service("pvUserService")
public class PvUserServiceImpl implements PvUserService {

    @Autowired
    Pv_UserMapper pvUserMapper;
    @Override
    public Pv_User selectByPrimaryKey(String storeId, String userId) {

        Pv_UserKey pvUserKey = new Pv_UserKey();
        pvUserKey.setStoreId(storeId);
        pvUserKey.setUserID(userId);
        Pv_User pvUser = pvUserMapper.selectByPrimaryKey(pvUserKey);
        return pvUser;
    }
}
