package com.ldg.wx.bo.in;


import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.WX_Util;

public class WX_Text extends WXInBasicMsg {
	private String Content; // 文本消息内容

	public WX_Text() {
		super();
	}

	public WX_Text(String text) {
		super(text);
		this.Content = WX_Util.getXMLCDATA(text, WeixinConstant.IN_TEXT_Content);
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "WX_Text [Content=" + Content + "]    " + super.toString();
	}

}
