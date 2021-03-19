package com.pindian.lonphy.domain.sms;

import java.io.Serializable;


public class SmsTemplate implements Serializable{
	private TemplateSms templateSMS;

	public TemplateSms getTemplateSMS() {
		return templateSMS;
	}

	public void setTemplateSMS(TemplateSms templateSMS) {
		this.templateSMS = templateSMS;
	}

	public SmsTemplate(TemplateSms templateSMS) {
		super();
		this.templateSMS = templateSMS;
	}
	
}
