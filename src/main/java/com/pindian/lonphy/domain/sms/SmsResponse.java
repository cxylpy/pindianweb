package com.pindian.lonphy.domain.sms;

import java.io.Serializable;

public class SmsResponse implements Serializable{
	private SmsSubResponse resp;

	public SmsSubResponse getResp() {
		return resp;
	}

	public void setResp(SmsSubResponse resp) {
		this.resp = resp;
	}

	public SmsResponse(SmsSubResponse resp) {
		this.resp = resp;
	}
	
}
