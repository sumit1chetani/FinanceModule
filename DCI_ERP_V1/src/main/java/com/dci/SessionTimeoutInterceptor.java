package com.dci;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dci.tenant.user.UserDetail;


public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HttpSession session;
	//private static final long MAX_INACTIVE_SESSION_TIME = 200000*1000;
	//private static final long MAX_INACTIVE_SESSION_TIME = 200000*1000;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//log.info("Pre handle method - check handling start time");
	    long startTime = System.currentTimeMillis();
	    request.setAttribute("executionTime", startTime);
	    if (isUserLogged()) {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	UserDetail userDetail = (UserDetail) authentication.getPrincipal();
	    	session = request.getSession();
	    	session.setMaxInactiveInterval(86400);
	       /* System.out.println("Time since last request in this session: {} ms"+
	          (System.currentTimeMillis() - request.getSession().getLastAccessedTime()));*/
//	        if (System.currentTimeMillis() - session.getLastAccessedTime()
//	          > MAX_INACTIVE_SESSION_TIME) {
//	           // log.warn("Logging out, due to inactive session");
//	            SecurityContextHolder.clearContext();
//	            request.logout();
//	            String scheme = request.getScheme(); // http
//	            String host = request.getServerName();  // host
//	            int port = request.getServerPort();  // port
//	            response.sendRedirect(scheme+"://"+host+":"+port+"/Athena/login");
//	            return false;
//	        }
	    }
	    return true;
	}
	
	public static boolean isUserLogged() {
	    try {
	        return !SecurityContextHolder.getContext().getAuthentication()
	          .getName().equals("anonymousUser");
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
