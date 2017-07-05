package com.ldg.wx.controller;

import com.ldg.base.api.util.LdgRequestUtil;
import com.ldg.wx.bo.ValidateMSG;
import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.Access_token;
import com.ldg.wx.utils.JSSDK_Sign;
import com.ldg.wx.utils.PropertiesUtil;
import com.ldg.wx.utils.WX_Util;
import com.ldg.wx.utils.wxaes.AesException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by LiuDongguang on 2017/7/5.
 */
@Controller
@RequestMapping(value = "/jssdk")
public class WXJSSDKController {
    @RequestMapping(value = "/jumpToPage")
    public String test1(HttpServletRequest request, HttpServletResponse response,String redirectURL) {
        String ticket = Access_token.getJsapi_ticket();
        Map<String, String> ret = JSSDK_Sign.sign(ticket, LdgRequestUtil.getFullJspPath(request,redirectURL));
        ret.put("appId", PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_CORPID));
        request.setAttribute("sign",ret);
        return redirectURL;
    }
}
