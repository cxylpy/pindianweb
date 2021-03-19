package com.pindian.lonphy.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class ParameterFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		Map<String, String[]> map = request.getParameterMap();
		if (request.getRequestURI().endsWith("get")) {
			chain.doFilter(req, arg1);
			return;
		}
		if (request.getRequestURI().endsWith("login")
				|| request.getRequestURI().endsWith("register")) {
			for (Entry<String, String[]> entry : map.entrySet()) {
				String[] values = entry.getValue();
				for (int i = 0; i < values.length; i++) {
					values[i] = StringUtils.replaceEach(values[i],
							new String[] { "'", "\"", "#" }, new String[] {
									"\\'", "\\\"", "\\#" });
				}
			}
		}
		chain.doFilter(req, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
