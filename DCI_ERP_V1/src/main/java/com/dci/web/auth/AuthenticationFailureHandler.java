package com.dci.web.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler
		implements
		org.springframework.security.web.authentication.AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response,
			org.springframework.security.core.AuthenticationException exception)
			throws IOException, ServletException {
		if(exception.getMessage() != null && !exception.getMessage().isEmpty()){
			request.getSession().setAttribute("message",exception.getMessage());
		}
		System.out.println(request.getParameter("tenantId"));
		if (request.getParameter("tenantId") != null) {
			String tenantId = request.getParameter("tenantId").toString();
			response.sendRedirect("/" + tenantId);
		}else{
			request.getRequestDispatcher("/" + "login").forward(request, response);
		}
	}

}