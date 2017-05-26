package com.dodonew.controller;

import com.dodonew.controller.helper.BackMapHelper;
import com.dodonew.controller.helper.BiBillHelper;
import com.dodonew.utils.ErrorEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

/**
 * Created by maxiao on 2017/5/12.
 */
@RestController
@RequestMapping("BiBillState")
public class BiBillStateController {

    @RequestMapping("get")
    public DeferredResult<Map<String,Object>> getState(@RequestParam Map<String,String> params){

        String billId = params.get("billId");
        String storeId = params.get("storeId");
        DeferredResult<Map<String,Object>> result = new DeferredResult<Map<String,Object>>();
        BiBillHelper.subscribeState(billId,storeId,result);
        return  result;
    }
}
