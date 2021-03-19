package com.pindian.lonphy.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.http.util.TextUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.UserService;

public class LoginInterceptor implements Interceptor{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("user");
		if(user==null) {
			return "loginfirst";
		}
		else 
			return invocation.invoke();
	}

}
