package com.dodonew.controller;

import com.dodonew.entityVo.RegMemberVo;
import com.dodonew.service.MemberService;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.ResultUtil;
import com.dodonew.utils.SMSMsgUtils;
import jvc.util.CacheUtils;
import jvc.util.RandomUtils;
import jvc.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yukx on 17/5/5.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/getCheckCode")
    public String getCheckCode(@RequestParam("mobile") String mobile) {
        int code = 0;
        if (StringUtils.isBlank(mobile)) {
            code = ErrorEnum.MOBILE_ISNULL.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        int checkCode = CacheUtils.getInt("regMember" + mobile);
        if (checkCode <= 0) {
            checkCode = RandomUtils.getNextRandomInt(1000, 9999);
            CacheUtils.put("regMember" + mobile, checkCode);
        }
        System.out.println(checkCode);
        SMSMsgUtils.sendSMS(mobile, "您的验证码为:" + checkCode);

        code = ErrorEnum.SUC.getCode();
        return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public String registerMember(@ModelAttribute RegMemberVo regMemberVo) {
        int code = 0;
        if (regMemberVo == null) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (StringUtils.isBlank(regMemberVo.getUnionId())) {
            code = ErrorEnum.UNIONID_ISNULL.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (StringUtils.isBlank(regMemberVo.getNickNmae())) {
            code = ErrorEnum.NAME_ISNULL.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (StringUtils.isBlank(regMemberVo.getMobile())) {
            code = ErrorEnum.MOBILE_ISNULL.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        if (regMemberVo.getCheckCode() <= 0) {
            code = ErrorEnum.CHECKCODE_ISNULL.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }

        int myCode = CacheUtils.getInt("regMember" + regMemberVo.getMobile().trim());
        if (myCode != regMemberVo.getCheckCode()) {
            code = ErrorEnum.CHECK_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        CacheUtils.remove("regMember" + regMemberVo.getMobile().trim());

        memberService.register(regMemberVo);

        code = ErrorEnum.SUC.getCode();
        return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
    }
}
