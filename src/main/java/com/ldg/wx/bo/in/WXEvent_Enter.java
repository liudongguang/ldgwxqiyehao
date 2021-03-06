package com.ldg.wx.bo.in;


import com.ldg.wx.constant.WeixinConstant;
import com.ldg.wx.utils.WX_Util;

public class WXEvent_Enter extends WXEventInBasicMsg {
	private String EventKey;

	public WXEvent_Enter(String message) {
		super(message);
		this.EventKey = WX_Util.getXMLCDATA(message, WeixinConstant.IN_COMM_EventKey);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		return super.toString() + "   WXEvent_Enter [EventKey=" + EventKey + "]";
	}

}
