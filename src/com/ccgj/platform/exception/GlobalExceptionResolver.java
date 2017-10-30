package com.ccgj.platform.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局异常处理�?
 * @author John
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{
   
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		GlobalException globalException=null;
		if(ex instanceof GlobalException){
			globalException=(GlobalException) ex;
		}else{
			globalException=new GlobalException("未知错误");
		}
		String message=globalException.getMessage();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
