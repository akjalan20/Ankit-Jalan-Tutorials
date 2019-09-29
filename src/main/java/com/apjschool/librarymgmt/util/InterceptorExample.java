package com.apjschool.librarymgmt.util;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.apjschool.librarymgmt.service.BookService;

@Component
public class InterceptorExample extends HandlerInterceptorAdapter {

	private static final Logger logger = LogManager.getLogger(BookService.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * If this method returns true then application will further handle the request
		 * else it will return back to client from this point itself
		 */

		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			response.getWriter().write("The website is down for maintenence on Sundays");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/*
		 * This method will be called after Spring MVC executes the request handler
		 * method for the request
		 */
		System.out.println("InterceptorExample:postHandle " + request.getRequestURL().toString());

		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*
		 * This method will be called after the response object is produces by the view
		 * for the request
		 */
		System.out.println("InterceptorExample:afterCompletion " + request.getRequestURL().toString());

	}

}
