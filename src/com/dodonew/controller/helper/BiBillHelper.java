package com.dodonew.controller.helper;

import com.dodonew.utils.DdnPayUtil;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.ResponseType;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;

/**
 * Created by maxiao on 2017/5/12.
 */
public class BiBillHelper {


    public static  void subscribeState(String billId,String storeId,DeferredResult< Map<String,Object>> deferredResult){

        ResponseType<DeferredResult<Map<String, Object>>,BillDes> responseType = new ResponseType<DeferredResult<Map<String, Object>>,BillDes>();
        responseType.entity = deferredResult;
        responseType.extra = new  BiBillHelper().new BillDes();
            new Date();
        responseType.extra.storeId = storeId;
        stateMap.put(billId,responseType);
    }

    public static  void triggerEve(String billId){

        ResponseType <DeferredResult< Map<String,Object>>,BillDes> responseType =
                stateMap.get(billId);
        if(responseType == null){

            successList.add(billId);
        }else {

           orderSuccess( stateMap.get(billId).entity,billId);
        }
    }

    public  static  void  orderSuccess(DeferredResult<Map<String, Object>> deferredResult,String billId){

        deferredResult.setResult(BackMapHelper.back(ErrorEnum.SUC));
        stateMap.remove(billId);

    }

    public  static  void  orderFail(DeferredResult<Map<String, Object>> deferredResult,String billId){

        deferredResult.setResult(BackMapHelper.back(ErrorEnum.BILL_FAIL));
        stateMap.remove(billId);

    }

    private static Map<String,ResponseType <DeferredResult< Map<String,Object>>,BillDes>>  stateMap =
         new Hashtable<String,ResponseType <DeferredResult< Map<String,Object>>,BillDes>>();
    private static  List<String> successList =  new Vector<String>();

    static {
        Timer timer = new  Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.SECOND,cal.get(Calendar.SECOND) - 20);
                Iterator<Map.Entry<String, ResponseType<DeferredResult<Map<String, Object>>, BillDes>>> it = stateMap.entrySet().iterator();
                while (it.hasNext()){
                    final Map.Entry<String, ResponseType<DeferredResult<Map<String, Object>>, BillDes>> entry = it.next();
                    final  ResponseType<DeferredResult< Map<String,Object>>,BillDes>   responseType = entry.getValue();

                    if(successList.contains(entry.getKey())){

                       orderSuccess(responseType.entity,entry.getKey());
                    }
                    //判断是否到了返回时间
                    if(responseType.extra.time.before(cal.getTime())){
                        //主动请求支付中心checkBill
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                               if( DdnPayUtil.checkOrderStatus(entry.getKey(),responseType.extra.storeId)){
                                   orderSuccess(responseType.entity,entry.getKey());
                               }else {
                                   orderFail(responseType.entity,entry.getKey());
                               }

                            }
                        });

                    }
                }
            }
        },0,1000);
    }

    class BillDes{
        Date time;
        String storeId;
    }
}
