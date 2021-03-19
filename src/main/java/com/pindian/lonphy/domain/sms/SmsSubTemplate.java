package com.pindian.lonphy.domain.sms;

import java.io.Serializable;

public class SmsSubTemplate implements Serializable{
	private long createDate;
	private String smsId;
	public long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public String getSmsId() {
		return smsId;
	}
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
	public SmsSubTemplate(long createDate, String smsId) {
		this.createDate = createDate;
		this.smsId = smsId;
	}
	
}
