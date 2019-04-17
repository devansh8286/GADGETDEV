//package com.project.Frontend.exception;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//@ControllerAdvice
//public class DefaultExceptionHandler {
//
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ModelAndView handlerNoHandlerFoundException() {
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("errorTitle", "The page is not Exist!!!");
//		mv.addObject("errorDescription", "The Page Looking for Not available  :)");
//		mv.addObject("title", "404 page not found");
//		return mv;
//
//	}
//
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ModelAndView handlerProductNotFoundException() {
//
//		ModelAndView mv = new ModelAndView("error");
//
//		mv.addObject("errorTitle", "Product not available!");
//
//		mv.addObject("errorDescription", "The product you are looking for is not available right now!");
//
//		mv.addObject("title", "Product Unavailable");
//
//		return mv;
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handlerException(Exception ex) {
//
//		ModelAndView mv = new ModelAndView("error");
//
////		for debugging application
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//
//		ex.printStackTrace(pw);
//
//		mv.addObject("errorTitle", sw.toString());
//
//		mv.addObject("errorDescription", ex.toString());
//
//		mv.addObject("title", "Product Unavailable error");
//
//		return mv;
//	}
//
//}
