package com.dci;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dci.tenant.user.UserDetail;


@Controller
public class WelcomeController {

	@RequestMapping(value = { "/admin" })
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("pages-sign-in");
		if (request.getAttribute("message") != null
				&& !request.getAttribute("message").toString().isEmpty()) {
			String message = request.getAttribute("message").toString();
			mv.addObject("message", message);
		}
		mv.addObject("tenantId", "admin");
		mv.addObject("loginType", "Admin");
		return mv;
	}

	@RequestMapping("/{tenantid}")
	public ModelAndView intermediatePage(@PathVariable String tenantid,
			HttpServletRequest request) {
		ModelAndView mv = null;
		if (request.getAttribute("message") != null
				&& !request.getAttribute("message").toString().isEmpty()) {
			mv = new ModelAndView("pages-sign-in");
			String message = request.getAttribute("message").toString();
			mv.addObject("message", message);
		} else {
			mv = new ModelAndView("pages-sign-in");
		}
		mv.addObject("tenantId", tenantid);
		mv.addObject("loginType", "Tenant");
		return mv;
	}

	@RequestMapping("/{tenantid}/login")
	public ModelAndView welcomeTenant(@PathVariable String tenantid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("pages-sign-in");
		if (request.getAttribute("message") != null
				&& !request.getAttribute("message").toString().isEmpty()) {
			String message = request.getAttribute("message").toString();
			mv.addObject("message", message);
		}
		mv.addObject("tenantId", tenantid);
		mv.addObject("loginType", "Tenant");
		return mv;
	}

	@RequestMapping("/{tenantid}/loginsso")
	public ModelAndView welcomeTenantloginsso(@PathVariable String tenantid,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("loginsso");
		if (request.getAttribute("message") != null
				&& !request.getAttribute("message").toString().isEmpty()) {
			String message = request.getAttribute("message").toString();
			mv.addObject("message", message);
		}
		mv.addObject("tenantId", tenantid);
		mv.addObject("loginType", "Tenant");
		return mv;
	}
	
	
	@RequestMapping(value = "WEB-INF/pages/**")
	public ModelAndView getFoo(final HttpServletRequest request) {
		/*UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		Map<String, String> listUrlFormCodeMap = userDetails.getListUrlFormCodeMap();
		Map<String, String> addUrlFormCodeMap = userDetails.getAddUrlFormCodeMap();
		String formCode = "";

		if (listUrlFormCodeMap.containsKey(path)) {
			formCode = listUrlFormCodeMap.get(path);
		}
		if (formCode == null || formCode.isEmpty()) {
			if (addUrlFormCodeMap.containsKey(path)) {
				formCode = addUrlFormCodeMap.get(path);
			}
		}*/
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		AntPathMatcher apm = new AntPathMatcher();
		String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);
		ModelAndView mv = new ModelAndView(finalPath);
		return mv;
	}
	
	@RequestMapping (value = "/views/**", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView defaultPath(HttpServletRequest request) {
		
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String formCode = "";
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Map<String, String> listUrlFormCodeMap = userDetails.getListUrlFormCodeMap();
			Map<String, String> addUrlFormCodeMap = userDetails.getAddUrlFormCodeMap();
			if (listUrlFormCodeMap.containsKey(path)) {
				formCode = listUrlFormCodeMap.get(path);
			}
			if (formCode == null || formCode.isEmpty()) {
				if (addUrlFormCodeMap.containsKey(path)) {
					formCode = addUrlFormCodeMap.get(path);
				}
			}
		}
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		AntPathMatcher apm = new AntPathMatcher();
		String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);
		ModelAndView mv = new ModelAndView(finalPath);
		mv.addObject("form_code", formCode);
		return mv;
	}
}
