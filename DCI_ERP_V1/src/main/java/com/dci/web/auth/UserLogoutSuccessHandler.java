package com.dci.web.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterService;



@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	UserMasterService userMasterService;


	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		if (authentication != null) {
			UserDetail userDetail = (UserDetail) authentication.getPrincipal();
			HttpSession session = request.getSession(false);
			if(session != null){
				session.invalidate();
			}
			request.setAttribute("CURRENT_TENANT_IDENTIFIER", userDetail.getTenantId());
			userMasterService.insertUserLogIp(userDetail, "LOGOUT");
			response.sendRedirect("/" + userDetail.getTenantId() + "/login");
			
		}
	}
}