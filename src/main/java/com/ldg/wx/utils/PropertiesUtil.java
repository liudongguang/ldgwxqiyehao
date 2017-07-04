package com.ldg.wx.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class PropertiesUtil {
	private static Properties weixinProperties = new Properties();
	static {
		ClassPathResource cr = new ClassPathResource("weixin.properties");
		try {
			weixinProperties.load(cr.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String weixinPropertiesVal(String key) {
		return weixinProperties.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesUtil.weixinPropertiesVal("token"));
	}
}
