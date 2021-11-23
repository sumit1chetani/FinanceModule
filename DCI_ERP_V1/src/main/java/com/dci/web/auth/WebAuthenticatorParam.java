package com.dci.web.auth;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.dci.common.util.CommonUtil;

@Component
public class WebAuthenticatorParam extends WebAuthenticationDetailsSource
		implements ApplicationContextAware, Serializable {
	
	private static Logger logger = Logger.getLogger(WebAuthenticatorParam.class
			.getName());
	private final boolean isDebugEnabled = logger.isDebugEnabled();
	private ApplicationContext context;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}

	public WebAuthenticatorParam() {
	}

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new AuthenticationDetails(context);
	}

	public class AuthenticationDetails extends WebAuthenticationDetails
			implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final String tenantId;
		private final String macAddress;
//		private final String accessLocation;
//		private final String ipAddress;
		private final String loginUrl;
		private final Integer tenantUserId;

		public AuthenticationDetails(HttpServletRequest request) {
			super(request);
			if(isDebugEnabled){
		    	  logger.debug("request.getParameter(macAddress)   "+request.getParameter("macAddress"));
		    	  logger.debug("request.getParameter(tenantId)   "+request.getParameter("tenantId"));
		     }
			 logger.debug("context : "+context);
			CommonUtil commonUtil = new CommonUtil();
			this.tenantId = request.getParameter("tenantId")!=null?request.getParameter("tenantId").toString():"";
			this.tenantUserId = request.getParameter("tenantUserId")!=null?Integer.parseInt(request.getParameter("tenantUserId").toString()):null;
			this.macAddress = request.getParameter("macAddress")!=null?request.getParameter("macAddress").toString():"";
//			this.ipAddress = commonUtil.getIpAddress(request);
//			this.accessLocation = commonUtil.getAccessLocation("ip");
			String url[] = (request.getRequestURL().toString())
					.split("/");
			String loginURL = url[0] + "/" + url[1] + "/"
					+ url[2] + "/" + tenantId + "/";
			this.loginUrl = loginURL;
			
			if(isDebugEnabled){
		    	  logger.debug("macAddress     : "+this.macAddress);
		    	  logger.debug("tenantId       : "+this.tenantId);
//		    	  logger.debug("ipAddress      : "+this.ipAddress);
//		    	  logger.debug("accessLocation : "+this.accessLocation);
		    	  logger.debug("loginURL       : "+loginURL);
		     }
		}

		public String getTenantId() {
			return tenantId;
		}

		public String getMacAddress() {
			return macAddress;
		}

//		public String getAccessLocation() {
//			return accessLocation;
//		}

//		public String getIpAddress() {
//			return ipAddress;
//		}

		public String getLoginUrl() {
			return loginUrl;
		}

		public Integer getTenantUserId() {
			return tenantUserId;
		}
	}
}
