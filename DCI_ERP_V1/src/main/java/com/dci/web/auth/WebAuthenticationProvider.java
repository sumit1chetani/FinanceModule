/**
 *
 */
package com.dci.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dci.common.util.CipherCrypto;
import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterService;
import com.dci.web.auth.WebAuthenticatorParam.AuthenticationDetails;

/**
 * @author buvana
 * @since 07-Jun-2017
 *
 */

@Component
public class WebAuthenticationProvider implements AuthenticationProvider {
	private static Logger logger = Logger
			.getLogger(WebAuthenticationProvider.class.getName());
	private final boolean isDebugEnabled = logger.isDebugEnabled();

	@Autowired
	UserMasterService userMasterService;


	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		UserDetail user = new UserDetail();
		WebAuthenticationDetails wad=(WebAuthenticationDetails) authentication.getDetails();
		try {
			user.setUsername(username);
			Object obj = authentication.getDetails();
			HttpServletRequest request = attr.getRequest();
			HttpSession session = request.getSession(true);
			if (obj instanceof AuthenticationDetails) {
				AuthenticationDetails authParam = (AuthenticationDetails) obj;
				if(authParam.getTenantUserId() == null || authParam.getTenantUserId() == 0){
					if (username.contains("*") || username.contains("|")) {
						logger.error("Username provided is not allowed");
						throw new BadCredentialsException(
								"Username provided is not allowed.");
					}
					if (username.length() == 0) {
						if (isDebugEnabled)
							logger.debug("@@@@ Username provided is empty.");
						throw new BadCredentialsException("Username provided is empty.");
					}
					if (password.length() == 0) {
						if (isDebugEnabled)
							logger.debug("@@@@ Credential provided is empty.");
						throw new BadCredentialsException(
								"Credential provided is empty.");
					}
				}
				if(authParam.getTenantId().equals("admin")){
					if(username.equals("admin") && password.equals("admin")){
						session.setAttribute("isMaster", true);
					}else{
						throw new BadCredentialsException("Username or Password doesn't match.");
					}
					user.setUsername(username);
				}else{
					request.setAttribute("CURRENT_TENANT_IDENTIFIER", authParam.getTenantId());
					user = userMasterService.loadUserByUsername(username);
					if (StringUtils.isBlank(user.getUserId())) {
						throw new BadCredentialsException("Username not found.");
					}

					if (!(user.getPassword()).equals(CipherCrypto.Encrypt(password))) {
						throw new BadCredentialsException("Wrong password.");
					}
					user.setUserIpAddress(wad.getRemoteAddress());

//			        int count=userMasterService.getcount(username);
//                    if(count>0)
//			        {
                        user.setCompanyUserId(userMasterService.getCompanyUserId(user.getCompanyCode(), user.getUserId()));
						user.setAuthorities(userMasterService.loadPermissionsByUsername(user.getCompanyUserId(), user.isAgent()));
						user.setlFormMasterBean(userMasterService.getFormMasterListAll(user.getCompanyUserId(), user.isAgent()));
						user.setListUrlFormCodeMap(userMasterService.getFormCodeUrlMap());
						user.setAddUrlFormCodeMap(userMasterService.getAddUrlFormCodeMap());
						
//					}
//					else
//					{
//						
//						user.setAuthorities(userMasterService.loadPermissionsByUsernameCustomer(user.isAgent()));
//						user.setlFormMasterBean(userMasterService.getFormMasterListAll(user.getCompanyUserId(), user.isAgent()));
//						user.setListUrlFormCodeMap(userMasterService.getFormCodeUrlMap());
//						user.setAddUrlFormCodeMap(userMasterService.getAddUrlFormCodeMap());
//					}
//			
					
					
					/*Integer count = containerTypeService.getcount(username, password);
					if(count != null && count > 0){
						session.setAttribute("isMaster", false);
					}else{
						throw new BadCredentialsException("Username or Password doesn't match.");
					}*/
					
				}
				user.setTenantId(authParam.getTenantId());
				/*grantedAuthorities.add(new SimpleGrantedAuthority(
						"ADMIN"));*/
			}
			userMasterService.insertUserLogIp(user,"LOGIN");
			authentication = new UsernamePasswordAuthenticationToken(user,
					authentication.getCredentials(), user.getAuthorities());
			return authentication;
		} catch (BadCredentialsException e) {
			throw e;
		} catch (Exception e) {
			throw new BadCredentialsException("Please contact support!.");
		}
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}
}