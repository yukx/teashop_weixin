
----------

**简要：**

该接口文档涉及微信,老版助手,门户,收银台

**文档信息**

> <small>创建人：喻凯旋</small>
>
> <small>创建日期：2017年04月13号</small>


##  1. HTTPS请求方式

----------

#### 1.1 Api Address    
**<font color="blue">POST</font>**

    http://219.133.59.27:9101/haowangPay_api/类名/方法名.do

</br>
</br>

## 3.返回格式说明

#### 3.1 Json 结果参数
字段    |类型   |描述
-------|------|------
code|String|结果代码（必须）
data|Object|返回的结果集(失败的时候不会有/或者为空)
message|String|错误原因或其他消息

----------
#### 3.2 code 结果参数

字段    |类型   |描述
-------|------|------
2000|SUC|操作成功
5001|PARAM_ERROR|参数错误
5002|SYSTEM_ERROR|系统异常
5003|SIGN_ERROR|签名错误

