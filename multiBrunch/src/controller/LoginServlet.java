package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/user/login.jsp";
		
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("loginUser") != null) {
			url = "/user/login.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "user/login.jsp";
		
		String uEmail = req.getParameter("uEmail");
		String uPassword = req.getParameter("uPassword");
		
		UserDao uDao = UserDao.getInstance();
		int result = uDao.userCheck(uEmail, uPassword);
		System.out.println(111);
		
		if(result==1) {
			User uVo = uDao.selectUser(uEmail);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", uVo);
			req.setAttribute("message", "로그인에 성공했습니다.");
			url="user/main.jsp";
		}else if(result==0) {
			req.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result==-1) {
			req.setAttribute("message", "존재하지 않는 회원입니다.");

		}
		System.out.println(111111);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
