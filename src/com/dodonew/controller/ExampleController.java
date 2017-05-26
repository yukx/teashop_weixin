package com.dodonew.controller;

import com.dodonew.model.WxMember;
import com.dodonew.pageUtil.PagedResult;
import com.dodonew.service.ExampleService;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yukx on 17/4/11.
 */

@Controller
@RequestMapping("/example")
public class ExampleController {
    Logger logger = Logger.getLogger(ExampleController.class);

    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "/queryByPage")
    @ResponseBody
    public String queryByPage(@ModelAttribute WxMember wxMember) {
        int code = 0;
        if (wxMember.getPageNo() == 0 || wxMember.getPageSize() == 0) {
            code = ErrorEnum.PARAM_ERROR.getCode();
            return ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }
        PagedResult<WxMember> result = exampleService.queryByPage(wxMember);
        code = ErrorEnum.SUC.getCode();
        return ResultUtil.resultJson(code, ErrorEnum.getMsg(code), JSONObject.fromObject(result));
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello word");
        int a = 2;
        int b = 0;
        int c = a / b;

        System.out.println("hello");
        return "hello word";
    }
}
