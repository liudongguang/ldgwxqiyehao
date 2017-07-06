package com.ldg.wx.controller;

import com.ldg.base.api.util.LdgRequestUtil;
import com.ldg.wx.utils.JSSDK_Sign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by LiuDongguang on 2017/7/5.
 */
@Controller
@RequestMapping(value = "/jssdk")
public class WXJSSDKController {
    private static Logger logger = LoggerFactory.getLogger(WXJSSDKController.class);
    @RequestMapping(value = "/jumpToPage")
    public String test1(HttpServletRequest request, HttpServletResponse response,String redirectURL) {
        StringBuilder url=new StringBuilder();
        url.append(request.getRequestURL()).append(LdgRequestUtil.getParamsStr(request));
        Map<String,String> ret= JSSDK_Sign.sign(url.toString());
        request.setAttribute("sign",ret);
        //logger.debug(url.toString());
        //logger.debug(redirectURL);
        return redirectURL;
    }
}
