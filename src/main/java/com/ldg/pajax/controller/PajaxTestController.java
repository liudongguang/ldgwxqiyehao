package com.ldg.pajax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiuDongguang on 2017/7/5.
 */
@Controller
@RequestMapping(value = "/pajaxtest")
public class PajaxTestController {
    private static Logger logger = LoggerFactory.getLogger(PajaxTestController.class);

    @RequestMapping(value = "/test1")
    public String test1(HttpServletRequest request, HttpServletResponse response,String redirectURL) {

        return redirectURL;
    }
}
