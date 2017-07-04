package com.ldg.wx.utils.msgcrypt;


import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.PropertiesUtil;
import com.ldg.wx.utils.wxaes.AesException;
import com.ldg.wx.utils.wxaes.WXBizMsgCrypt;

public class WXHuiHuanBizMsgCryptSingleton {
	private static String token = PropertiesUtil.weixinPropertiesVal(WeixinConstant.WXHUIHUA_PARAM_TOKEN);
	private static String corpid = PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_CORPID);
	private static String encodingaeskey = PropertiesUtil.weixinPropertiesVal(WeixinConstant.WXHUIHUA_ENCODINGAESKEY);
	private volatile static WXBizMsgCrypt wmc = null;

	private WXHuiHuanBizMsgCryptSingleton() {

	}

	public static WXBizMsgCrypt getWXBizMsgCryptInstance() {
		if (wmc == null) {
			synchronized (WXHuiHuanBizMsgCryptSingleton.class) {
				if (wmc == null) {
					try {
						wmc = new WXBizMsgCrypt(token, encodingaeskey, corpid);
					} catch (AesException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return wmc;
	}
}
