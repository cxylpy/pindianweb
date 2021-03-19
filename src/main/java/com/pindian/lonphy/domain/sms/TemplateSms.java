package com.pindian.lonphy.domain.sms;

import java.io.Serializable;

public class TemplateSms implements Serializable{
	public String appId;
	public String param;
	public String templateId;
	public String to;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public TemplateSms(String appId, String param, String templateId, String to) {
		this.appId = appId;
		this.param = param;
		this.templateId = templateId;
		this.to = to;
	}
	
}
