package com.ldg.pajax.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldg.base.api.constant.SysConstant;
import com.ldg.base.api.util.HttpClientUtil;
import com.ldg.base.api.util.JsonUtil;
import com.ldg.pajax.vo.WX_Response_Base;
import com.ldg.pajax.vo.WX_Response_department;
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
    public String getDepart(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.qy_getAllDepart), Access_token.getAccessToken());
        String rsStr= HttpClientUtil.getInstance().sendHttpGet(getDepartURL);
        WX_Response_department_list rsDepartments= JsonUtil.getObjectByJSON(rsStr,WX_Response_department_list.class);
        request.setAttribute(SysConstant.datalist,rsDepartments);
        return "/jsp/pajax/weixin/departList.jsp";
    }

    /**
     * 添加部门
     * @param request
     * @param response
     * @param department
     * @return
     * @throws InterruptedException
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/addDepart")
    public String addDepart(HttpServletRequest request, HttpServletResponse response, WX_Response_department department) throws InterruptedException, JsonProcessingException {
        department.setParentid(1);
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.addDepart), Access_token.getAccessToken());
        String rsStr= HttpClientUtil.getInstance().sendHttpPostJson(getDepartURL,JsonUtil.parseToJson(department));
        WX_Response_Base rsInfo=JsonUtil.getObjectByJSON(rsStr,WX_Response_Base.class);
        request.setAttribute(SysConstant.rsInfo,rsInfo);
        return "/pajaxwx/getDepart";
    }

    /**
     * 删除部门
     * @param request
     * @param response
     * @param department
     * @return
     * @throws InterruptedException
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/delDepart")
    public String delDepart(HttpServletRequest request, HttpServletResponse response, WX_Response_department department) throws InterruptedException, JsonProcessingException {
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.delDepart), Access_token.getAccessToken(),department.getId());
        String rsStr= HttpClientUtil.getInstance().sendHttpGet(getDepartURL);
        WX_Response_Base rsInfo=JsonUtil.getObjectByJSON(rsStr,WX_Response_Base.class);
        request.setAttribute(SysConstant.rsInfo,rsInfo);
        return "/pajaxwx/getDepart";
    }

    @RequestMapping(value = "/updateDepart")
    public String updateDepart(HttpServletRequest request, HttpServletResponse response, WX_Response_department department) throws InterruptedException, JsonProcessingException {
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.updateDepart), Access_token.getAccessToken());
        String rsStr= HttpClientUtil.getInstance().sendHttpPostJson(getDepartURL,JsonUtil.parseToJson(department));
        WX_Response_Base rsInfo=JsonUtil.getObjectByJSON(rsStr,WX_Response_Base.class);
        request.setAttribute(SysConstant.rsInfo,rsInfo);
        return "/pajaxwx/getDepart";
    }

}
