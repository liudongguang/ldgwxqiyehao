package com.ldg.pajax.controller;

import com.ldg.base.api.constant.SysConstant;
import com.ldg.base.api.util.HttpClientUtil;
import com.ldg.base.api.util.JsonUtil;
import com.ldg.pajax.vo.WX_Response_department_list;
import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.Access_token;
import com.ldg.wx.utils.PropertiesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by LiuDongguang on 2017/9/6.
 */
@Controller
@RequestMapping(value = "/pajaxwx")
public class PajaxWXController {
    /**
     *  获取部门
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getDepart")
    public String getDepart(HttpServletRequest request, HttpServletResponse response) {
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.qy_getAllDepart), Access_token.getAccessToken());
        String rsStr= HttpClientUtil.getInstance().sendHttpGet(getDepartURL);
        WX_Response_department_list rsDepartments= JsonUtil.getObjectByJSON(rsStr,WX_Response_department_list.class);
        request.setAttribute(SysConstant.datalist,rsDepartments);
        return "/jsp/pajax/weixin/departList.jsp";
    }
}
