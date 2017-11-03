package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/emailCheck.do")
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uEmail = req.getParameter("uEmail");

		UserDao uDao = UserDao.getInstance();

		int result = uDao.confirmEmail(uEmail);

		req.setAttribute("uEmail", uEmail);
		req.setAttribute("result", result);

		RequestDispatcher dispatcher = req.getRequestDispatcher("user/emailCheck.jsp");
		dispatcher.forward(req, resp);

	}

}
