package com.dodonew.service.impl;

import com.dodonew.dao.EZ_GoodsCustomerMapper;
import com.dodonew.dao.EZ_GoodsSpecCustomerMapper;
import com.dodonew.model.EZ_GoodsCustomer;
import com.dodonew.model.EZ_GoodsSpecCustomer;
import com.dodonew.service.EzGoodsCustomerService;
import com.dodonew.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maxiao on 2017/5/4.
 */
@Service("ezGoodsCustomerService")
public class EzGoodsCustomerServiceImpl  implements EzGoodsCustomerService {

    @Autowired
    EZ_GoodsCustomerMapper ezGoodsCustomerMapper;

    @Autowired
    EZ_GoodsSpecCustomerMapper ezGoodsSpecCustomerMapper;

    @Override
    public ResponseType<EZ_GoodsCustomer,EZ_GoodsSpecCustomer> selectBySpecCustomerId(Long specCustomerId) {

        ResponseType<EZ_GoodsCustomer,EZ_GoodsSpecCustomer> responseType = null;
        EZ_GoodsSpecCustomer spec = ezGoodsSpecCustomerMapper.selectByPrimaryKey(specCustomerId);

        if(spec != null){

            responseType = new ResponseType<EZ_GoodsCustomer,EZ_GoodsSpecCustomer> ();
            EZ_GoodsCustomer goods =  ezGoodsCustomerMapper.selectByPrimaryKey(spec.getGoodsCustomerId());
            responseType.entity = goods;
            responseType.extra = spec;
        }

        return responseType;
    }
}
