=begin

@api {post} /wxChatPay/login.do 02_小程序登录
@apiVersion 0.0.1
@apiName login
@apiGroup wechat

@apiParam {String} code 登录code,只能用一次

@apiSuccess (返回成功消息) {String} code 成功编码{1:成功}
@apiSuccess (返回成功消息) {String} message 成功消息.


@apiSuccessExample {json} 成功结果示例：
{
  "code": 2000,
  "message": "SUC"
}

=end