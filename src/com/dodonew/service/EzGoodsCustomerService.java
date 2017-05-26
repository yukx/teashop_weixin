package com.dodonew.service;

import com.dodonew.model.EZ_GoodsCustomer;
import com.dodonew.model.EZ_GoodsSpecCustomer;
import com.dodonew.utils.ResponseType;

/**
 * Created by maxiao on 2017/5/4.
 */
public interface EzGoodsCustomerService {

      ResponseType<EZ_GoodsCustomer,EZ_GoodsSpecCustomer> selectBySpecCustomerId(Long goodsCustomerId);
}
