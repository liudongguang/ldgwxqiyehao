package com.ldg.wx.utils;

import com.ldg.wx.constant.WeixinConstant;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSSDK_Sign {
	public static void main(String[] args) {
		String jsapi_ticket = "jsapi_ticket";

		// 注意 URL 一定要动态获取，不能 hardcode
		String url = "http://example.com";
		Map<String, String> ret = sign(url);
		for (Map.Entry entry : ret.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	};
    private static String getSignature(String tempStr){
		String signature = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(tempStr.toString().getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return signature;
	}
	public static Map<String, String> sign(String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		StringBuilder string1 = new StringBuilder();
		// 注意这里参数名必须全部小写，且必须有序
		string1.append("jsapi_ticket=").append(Access_token.getJsapi_ticket()).append("&noncestr=").append(nonce_str)
				.append("&timestamp=").append(timestamp).append("&url=").append(url);
		ret.put("appId", PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_CORPID));
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", getSignature(string1.toString()));
		return ret;
	}

	public static Map<String, String> signGroupTicket(String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		StringBuilder string1 = new StringBuilder();
		// 注意这里参数名必须全部小写，且必须有序
		string1.append("group_ticket=").append(Access_token.getGroup().getTicket()).append("&noncestr=").append(nonce_str)
				.append("&timestamp=").append(timestamp).append("&url=").append(url);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature",  getSignature(string1.toString()));
		ret.put("appId", PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_CORPID));
		return ret;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	public static String signForParam(String url) {
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		StringBuilder string1 = new StringBuilder();
		// 注意这里参数名必须全部小写，且必须有序
		string1.append("jsapi_ticket=").append(Access_token.getJsapi_ticket()).append("&noncestr=").append(nonce_str)
				.append("&timestamp=").append(timestamp).append("&url=").append(url);
		String signature=getSignature(string1.toString());
		StringBuilder rsStr=new StringBuilder();
		rsStr.append("appId=").append(PropertiesUtil.weixinPropertiesVal(WeixinConstant.WX_CORPID));
		rsStr.append("&timestamp=").append(timestamp);
		rsStr.append("&nonceStr=").append(nonce_str);
		rsStr.append("&signature=").append(signature);
		return  rsStr.toString();
	}
}
