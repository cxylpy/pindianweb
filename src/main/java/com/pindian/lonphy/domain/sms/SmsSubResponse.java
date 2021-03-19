package com.pindian.lonphy.domain.sms;

import java.io.Serializable;

public class SmsSubResponse implements Serializable{
	private String respCode;
	private String failure;
	private SmsSubTemplate templateSMS;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	public SmsSubTemplate getTemplateSMS() {
		return templateSMS;
	}
	public void setTemplateSMS(SmsSubTemplate templateSMS) {
		this.templateSMS = templateSMS;
	}
	public SmsSubResponse(String respCode, String failure,
			SmsSubTemplate templateSMS) {
		this.respCode = respCode;
		this.failure = failure;
		this.templateSMS = templateSMS;
	}
	
}
