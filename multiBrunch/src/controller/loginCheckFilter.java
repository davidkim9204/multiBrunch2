package controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

public class loginCheckFilter implements Filter{
	 public void init(FilterConfig config) throws ServletException{
		 
	 }
	 
	 public void doFilter(ServletRequest request, ServletResponse response,
			   FilterChain chain) throws IOException, ServletException
			 {
			  HttpServletRequest httpRequest = (HttpServletRequest) request;
			  HttpSession session = httpRequest.getSession(false);
			  
			  httpRequest.setCharacterEncoding("UTF-8");
			  boolean login = false;
			  if(session != null)
			  {
			   if(session.getAttribute("uId") != null && session.getAttribute("uId") != null)
			   {
			    login = true;    // 세션변수가  null이 아닐경우 true로 설정.
			   }
			  }
			  
			  if(login)
			  {
			    // 세션변수가 null이 아닐경우, 필터 체인을 거친 후, 요청한 페이지로 이동한다.
			    chain.doFilter(request, response);
			  }
			  else
			  {
			   // 세션변수가 null일 경우, 로그인 폼으로 이동한다.
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/kame_chbk/chap21/loginForm.jsp");
			   dispatcher.forward(request, response);
			  }
			 }
			 
			 public void destroy()
			 {
			  
			 }
	@Override
	public boolean test(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
