package com.webdiapp.access.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.webdiapp.constants.CommonConstants;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Object se = session.getAttribute(CommonConstants.LOGIN_SESSION_KEY);
		boolean result = true;
		if(se == null || "".equals(se)) {
//			result = false;
//			response.setStatus(403);
//			response.addHeader("login", "signin.html");
//			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		return result;
	}

}
