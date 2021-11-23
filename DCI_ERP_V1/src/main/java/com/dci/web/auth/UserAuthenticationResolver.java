package com.dci.web.auth;

import java.security.Principal;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.dci.tenant.user.UserDetail;


@Component
public class UserAuthenticationResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterAnnotation(UserAuthentication.class) != null && methodParameter.getParameterType().equals(UserDetail.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		if (this.supportsParameter(methodParameter)) {
			Principal principal = webRequest.getUserPrincipal();
			return ((Authentication) principal).getPrincipal();
		} else {
			return WebArgumentResolver.UNRESOLVED;
		}
	}
}
