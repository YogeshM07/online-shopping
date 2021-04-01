package net.kzn.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerFoundException() {
		
		ModelAndView mv =new ModelAndView("error");
		
		mv.addObject("errorTitle","The page is not Constructed");
		mv.addObject("errorDescription","the page you are looking is not constructed Now ");
		
		mv.addObject("title","404 error page");
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerproductNotFoundException() {
		
		ModelAndView mv =new ModelAndView("error");
		
		mv.addObject("errorTitle","Product Not Avilable");
		mv.addObject("errorDescription","the Product you are looking is not Available Now ");
		
		mv.addObject("title","product Unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv =new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact Your Administrator !!");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);  // you will get full lenth of exception 
		
		mv.addObject("errorDescription",sw.toString());
		
		mv.addObject("title","Error !!");
		return mv;
	}
	
}
