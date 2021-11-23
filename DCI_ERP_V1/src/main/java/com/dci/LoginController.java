package com.dci;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dci.master.domain.repository.AdminUserRepository;
import com.dci.tenant.domain.model.DashboardBean;
import com.dci.tenant.domain.service.LoginService;
import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterService;
import com.dci.web.auth.UserAuthentication;



@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class
			.getName());
	private final boolean isDebugEnabled = logger.isDebugEnabled();

	
	@Resource
	private AdminUserRepository adminUserRepository;
	
	@Resource
	private LoginService loginService;
	
	
	@Resource
	UserMasterService userMasterService;

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/")
	public ModelAndView authenticatenUser(HttpServletRequest request,
			@UserAuthentication UserDetail userDetail)
			throws ClientProtocolException, IOException {
		request.setAttribute("CURRENT_TENANT_IDENTIFIER",
				userDetail.getTenantId());
		HttpSession session = request.getSession(false);
		
		Integer roleId = null;
		if (session.getAttribute("idaasRoleId") != null
				&& !session.getAttribute("idaasRoleId").toString().isEmpty()) {
			roleId = Integer.valueOf(session.getAttribute("idaasRoleId").toString());
		}
		
		boolean isMaster = false;
		if (session.getAttribute("isMaster") != null
				&& !session.getAttribute("isMaster").toString().isEmpty()) {
			isMaster = Boolean.valueOf(session.getAttribute("isMaster").toString());
		}
		
		ModelAndView mv = new ModelAndView("templates/index");
		mv.addObject("empId", userDetail.getUserId());
		mv.addObject("userName", userDetail.getUsername());
		mv.addObject("tenantId", userDetail.getTenantId());
		mv.addObject("isMaster", isMaster);
		return mv;
	}

	

	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(HttpServletRequest request,
			HttpServletResponse response,Authentication authentication) throws ClientProtocolException,
			IOException, SQLException {
		ModelAndView mv = null;
		HttpSession session1 = request.getSession(false);
		String tenantId = "";
		UserDetail userDetail = (UserDetail) authentication.getPrincipal();
		userMasterService.insertUserLogIp(userDetail, "LOGOUT");
		// = request.getSession(false);
		if (session1 != null && session1.getAttribute("tenantUserId") != null) {
			Integer tenantUserId = Integer.parseInt(session1.getAttribute(
					"tenantUserId").toString());
			tenantId = (String) session1.getAttribute("tenantId");
			request.setAttribute("CURRENT_TENANT_IDENTIFIER", tenantId);

			session1.invalidate();
			String url = request.getScheme() + "://" + // "http" + "://
					request.getServerName() + // "myhost"
					":" + // ":"
					request.getServerPort() + "/" + tenantId + "/login";
			response.sendRedirect(url);
		}
		mv = new ModelAndView("forward:/" + tenantId + "/login");
		return mv;
	}
	
	@RequestMapping(value = "/loginagain")
	public ModelAndView logoutUser1(HttpServletRequest request) throws ClientProtocolException,
			IOException, SQLException {
		//ModelAndView mv = new ModelAndView("redirect:/admin");
		ModelAndView mv = new ModelAndView("redirect:/"+"login");
		return mv;
	}
	
	
	@RequestMapping(value = "/{tenantid}/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session1,
			@PathVariable String tenantid) throws ClientProtocolException,
			IOException, SQLException {
		ModelAndView mv = null;
		String tenantId = "";
		// = request.getSession(false);
		if (session1 != null && session1.getAttribute("tenantUserId") != null) {
			Integer tenantUserId = Integer.parseInt(session1.getAttribute(
					"tenantUserId").toString());
			tenantId = (String) session1.getAttribute("tenantId");
			request.setAttribute("CURRENT_TENANT_IDENTIFIER", tenantId);
			session1.invalidate();
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null){
			UserDetail userDetail = (UserDetail) authentication.getPrincipal();
			userMasterService.insertUserLogIp(userDetail, "LOGOUT");
		}
		String url = request.getScheme() + "://" + // "http" + "://
				request.getServerName() + // "myhost"
				":" + // ":"
				request.getServerPort() + "/" + tenantid + "/login";
		response.sendRedirect(url);
		mv = new ModelAndView("forward:/" + tenantid + "/login");
		// request.setAttribute("message",
		// "Signed out successfully");
		return mv;
	}
	
	@RequestMapping(value = "/{tenantid}/dashboardValues")
	public @ResponseBody DashboardBean getDashboardValues() throws Exception {
		DashboardBean dashboardBean = new DashboardBean();
		try {
			dashboardBean = loginService.getDashboardValues();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dashboardBean;
	}

}