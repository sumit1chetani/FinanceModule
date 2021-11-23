package com.dci.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		Map<String, Object> pathVars = (Map<String, Object>) req
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		String uri = req.getRequestURI();
		//System.out.println(uri);
		String name = "";
		if (pathVars.containsKey("tenantid")) {
			req.setAttribute("CURRENT_TENANT_IDENTIFIER",
					pathVars.get("tenantid"));
		}
		boolean isRedirect = false;
		if(uri.equalsIgnoreCase("/error")){
			isRedirect = true;
		}

		if (isRedirect) {
			//System.out.println(req.getAttribute("CURRENT_TENANT_IDENTIFIER"));
			if (pathVars.get("tenantid") != null
					&& !pathVars.get("tenantid").toString().isEmpty()) {
				name = req.getScheme() + "://" + req.getServerName() + ":"
						+ req.getServerPort() + "/" + pathVars.get("tenantid")
						+ "/login";
			} else {
				/*name = req.getScheme() + "://" + req.getServerName() + ":"
						+ req.getServerPort();*/
			}
			res.sendRedirect(name);
		}
		

		return super.preHandle(req, res, handler);
	}
	
}
