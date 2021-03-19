package com.pindian.lonphy.interceptor;

import java.util.Iterator;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.pindian.lonphy.domain.Manager;
import com.pindian.lonphy.domain.Privileges;

public class ManagerInterceptor implements Interceptor{
	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Manager manager = (Manager) ServletActionContext.getRequest().getSession().getAttribute("manager");
		if(manager==null) {
			return "manager_login";
		}
		ActionContext actionContext = invocation.getInvocationContext();
		//以jsp_开头或者以View结尾的action都直接通过
		if(actionContext.getName().startsWith("jsp_")||actionContext.getName().endsWith("View")||actionContext.getName().endsWith("view")) {
			return invocation.invoke();
		}
		Iterator<Privileges> iterator = manager.getRole().getPrivileges().iterator();
		boolean ok = false;
		while(iterator.hasNext()) {
			if(iterator.next().getAction().equals(actionContext.getName())) {
				ok = true;
				break;
			} 
		}
		if(ok)
		return invocation.invoke();
		else 
			return "no_privilege";
	}

}
