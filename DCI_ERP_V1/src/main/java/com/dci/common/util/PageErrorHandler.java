package com.dci.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.omg.CORBA.portable.UnknownException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class PageErrorHandler {
	


	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView constraintViolationException(
			ConstraintViolationException ex) {
		ModelAndView mav = new ModelAndView("pages-404");
		return mav;
	}

	@ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView noHandlerFoundException(HttpServletRequest request,
			Exception ex) {
		ModelAndView mav = new ModelAndView("pages-404");
		return mav;
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView unknownException(HttpServletRequest request,
			Exception ex) {
		ModelAndView mav = new ModelAndView("pages-500");
		return mav;
	}

	@ExceptionHandler(value = { UnknownException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView forbiddenException(Exception ex) {
		ModelAndView mav = new ModelAndView("pages-403");
		return mav;
	}

}
