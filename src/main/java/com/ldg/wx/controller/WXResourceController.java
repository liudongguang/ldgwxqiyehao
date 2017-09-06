package com.ldg.wx.controller;

import com.ldg.base.api.util.HttpClientUtil;
import com.ldg.base.api.util.JsonUtil;
import com.ldg.wx.bo.resource.depart.Department_rs;
import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.Access_token;
import com.ldg.wx.utils.PropertiesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by LiuDongguang on 2017/7/4.
 */
@Controller
@RequestMapping(value = "/wxresource")
public class WXResourceController {

    /**
     *  获取部门
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getDepart")
    @ResponseBody
    public Integer getDepart(HttpServletRequest request, HttpServletResponse response) {
        String getDepartURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.qy_getAllDepart), Access_token.getAccessToken());
        String rsStr= HttpClientUtil.getInstance().sendHttpGet(getDepartURL);
        Department_rs deprs= JsonUtil.getObjectByJSON(rsStr,Department_rs.class);
        deprs.getDepartment().forEach(dept->{
            String getEmpURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.GETXIANGXIEMPLOYEEBYDEPARTMENTID), Access_token.getAccessToken(),dept.getId(),1);
            String empStr= HttpClientUtil.getInstance().sendHttpGet(getEmpURL);
            System.out.println(empStr);
        });
        return 1;
    }
    //根据userid获取用户
    @RequestMapping(value = "/getDepartEMPByUserid")
    @ResponseBody
    public Integer getDepartEMPByUserid(HttpServletRequest request, HttpServletResponse response) {
        String getEmpURL=  MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.getUserinfoByUserid), Access_token.getAccessToken(),"5598");
        String empStr= HttpClientUtil.getInstance().sendHttpGet(getEmpURL);
        System.out.println(empStr);
        return 1;
    }
}
