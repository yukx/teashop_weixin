=begin
@api {post} /wxChatPay/check.do 01_验证服务器
@apiVersion 0.0.1
@apiName check
@apiGroup wechat

@apiParam {String} signature 签名.
@apiParam {String} timestamp 时间.
@apiParam {String} nonce 随机.
@apiParam {String} echostr 随机字符串.

@apiSuccess (返回成功消息) {String} echostr 返回echostr

=end