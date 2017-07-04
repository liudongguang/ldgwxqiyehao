package com.ldg.wx.controller;

import com.ldg.base.api.util.HttpClientUtil;
import com.ldg.wx.bo.ServerSendMSG;
import com.ldg.wx.bo.ValidateMSG;
import com.ldg.wx.bo.in.WXEvent_Enter;
import com.ldg.wx.bo.in.WXEvent_LOCATION;
import com.ldg.wx.bo.in.WX_Text;
import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.Access_token;
import com.ldg.wx.utils.PropertiesUtil;
import com.ldg.wx.utils.WX_Util;
import com.ldg.wx.utils.msgcrypt.WXBizMsgCryptSingleton;
import com.ldg.wx.utils.wxaes.AesException;
import com.ldg.wx.utils.wxaes.WXBizMsgCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by LiuDongguang on 2017/7/4.
 */
@Controller
@RequestMapping(value = "/ldgweixin")
public class WXMainController {
    /**
     * 接入验证
     *
     * @param validateMSG
     * @param response
     * @throws IOException
     * @throws AesException
     */
    @RequestMapping(value = "/handler", method = RequestMethod.GET)
    public void validate(ValidateMSG validateMSG, HttpServletRequest request, HttpServletResponse response)
            throws IOException, AesException {
        String vstr = WX_Util.validate(validateMSG);
        WX_Util.print(vstr, response);
    }

    /**
     * 接受微信服务端发过来的信息
     *
     * @param ssdMSG
     * @param request
     * @param response
     * @throws IOException
     * @throws AesException
     */
    @RequestMapping(value = "/handler", method = RequestMethod.POST)
    public void message(ServerSendMSG ssdMSG, HttpServletRequest request, HttpServletResponse response)
            throws IOException, AesException {
        String message = WX_Util.getStrInputStream(request);
        System.out.println(message);
        String encrypt = WX_Util.getXMLCDATA(message, WeixinConstant.IN_Encrypt);
        WXBizMsgCrypt wmc = WXBizMsgCryptSingleton.getWXBizMsgCryptInstance();
        message = wmc.decrypt(encrypt);// 解密
        String msgType = WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_MsgType);
        String sendMSGRUL = MessageFormat.format(PropertiesUtil.weixinPropertiesVal(WeixinConstant.SENDMSG),
                Access_token.getAccessToken());
        System.out.println(message);
        switch (msgType) {
            case WeixinConstant.WX_MESSAGETYPE_TEXT:
                // 接受信息
                WX_Text wxtext = new WX_Text(message);
                HttpClientUtil.getInstance().sendHttpPostJson(sendMSGRUL, "");
                break;
            case WeixinConstant.WX_MESSAGETYPE_EVENT:// 各种事件
                String eventName = WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_Event);
                switch (eventName) {
                    case WeixinConstant.IN_COMM_Event_enter_agent:
                        WXEvent_Enter enter_event = new WXEvent_Enter(message);
                        System.out.println("EVENT enter_agent:  " + enter_event);
                        // Text tx_enter = enter_event.getToUserMSG("进入应用...");
                        // String jsonStr_enter = JsonUtil.parseToJson(tx_enter);
                        HttpClientUtil.getInstance().sendHttpPostJson(sendMSGRUL, "");
                        break;
                    case WeixinConstant.IN_COMM_Event_LOCATION:
                        WXEvent_LOCATION location = new WXEvent_LOCATION(message);
                        System.out.println("EVENT LOCATION:  " + location);
                        HttpClientUtil.getInstance().sendHttpPostJson(sendMSGRUL, "");
                        break;
                    default:
                        System.out.println("未知事件..." + eventName);
                        HttpClientUtil.getInstance().sendHttpPostJson(sendMSGRUL, "");
                        break;
                }
                break;
            default:
                System.out.println("default   " + message);
                HttpClientUtil.getInstance().sendHttpPostJson(sendMSGRUL, "");
                break;
        }
    }
}
