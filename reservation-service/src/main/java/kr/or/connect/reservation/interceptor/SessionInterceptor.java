package kr.or.connect.reservation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class SessionInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
<<<<<<< HEAD
		if(session.getAttribute("user_id")!=null) {
=======
		if(session.getAttribute("user")!=null) {
>>>>>>> B_SungJiHyun_bb
			
			session.setAttribute("URL",request.getServletPath());
			
			return true;
			
		}else {
			
			session.setAttribute("URL", request.getServletPath());
			
			response.sendRedirect("/nlogin");
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
