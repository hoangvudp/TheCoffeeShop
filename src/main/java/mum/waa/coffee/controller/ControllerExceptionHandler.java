package mum.waa.coffee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import mum.waa.coffee.exception.ProductNotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getFullMessage());
		mav.setViewName("productNotFound");
		return mav;
	}
}
