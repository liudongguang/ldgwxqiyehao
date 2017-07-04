package com.ldg.base.controller;


import com.ldg.base.api.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/6/6.
 */
@Controller
@RequestMapping("/req")
public class TestController {
    @ResponseBody
    @RequestMapping("/test")
    public ResultMsg test(String text) {
        ResultMsg rs = new ResultMsg();
        return rs;
    }

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request) throws Exception {
        System.out.println("----------");
        return "/index.jsp";
    }

}
