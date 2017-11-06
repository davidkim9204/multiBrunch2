package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/userUpdate.do")
public class UserUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uEmail = req.getParameter("uEmail");
		UserDao uDao = UserDao.getInstance();
		
		User uVo = uDao.selectUser(uEmail);
		req.setAttribute("uVo", uVo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("user/userUpdate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uName = req.getParameter("uName");
		String uEmail = req.getParameter("uEmail");
		String uPassword = req.getParameter("uPassword");
		String uGender = req.getParameter("uGender");
		String uAge = req.getParameter("uAge");
		String uPreference = req.getParameter("uPreference");
		
		User uVo = new User();
		uVo.setuName(uName);
		uVo.setuEmail(uEmail);
		uVo.setuPassword(uPassword);
		uVo.setuGender(uGender);
		uVo.setuAge(Integer.parseInt(uAge));
		uVo.setuPreference(uPreference);
		
		UserDao uDao = UserDao.getInstance();
		
		uDao.updateUser(uVo);
		resp.sendRedirect("login.do");
	}
	
	
}
