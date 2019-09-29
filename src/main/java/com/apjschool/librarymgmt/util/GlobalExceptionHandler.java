package com.apjschool.librarymgmt.util;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * The ExceptionHandler method can be placed in the controller class or if it
	 * applies to multiple controllers then it can be placed in a special class
	 * marked as controllerAdvice. We can also make use of
	 * SimpleMappingExceptionResolver bean defined in the spring configuration class
	 * for exception handling.
	 * 
	 * If we do not set the response status to 500 then server will send 200-OK
	 */

	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView modelAndView = new ModelAndView("NPExceptionPage");
		return modelAndView;
	}

}
