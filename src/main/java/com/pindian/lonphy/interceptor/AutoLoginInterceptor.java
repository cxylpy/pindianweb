package com.pindian.lonphy.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.util.TextUtils;
import org.apache.struts2.ServletActionContext;

import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.UserService;

public class AutoLoginInterceptor implements Filter {
	private UserService uService = BaseFactory.getInstance(UserService.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getSession().getAttribute("user") == null) {
			String id = "";
			String encriptpassword = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("pindianppautologin")&&c.getMaxAge()==-1) {
						String value = c.getValue();
						String[] split = value.split(",");
						id = split[0];
						encriptpassword = split[1];
					}
				}
				if (!TextUtils.isEmpty(id)
						&& !TextUtils.isEmpty(encriptpassword)) {
					User u = uService.findUserByIdAndPassword(id,
							encriptpassword);
					request.getSession().setAttribute("user", u);
				}
			}
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
