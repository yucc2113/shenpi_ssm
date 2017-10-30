package com.ccgj.platform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.base.common.util.GlobalDefine;
import com.ccgj.database.beans.Users;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
	
		String url=request.getRequestURI();
	
		String path=request.getContextPath() ;
		
		if(url.indexOf("toLogin")>=0){
			return true;
		}
		HttpSession session=request.getSession();
		Users user = (Users)session.getAttribute(GlobalDefine.USER);
		if(user!=null){
			return true;
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(
					"<script>alert('登陆已过期,请重新登录!');window.top.location='"
							+ path + "/login.jsp';</script>");
			return false;
		}
	}

}
