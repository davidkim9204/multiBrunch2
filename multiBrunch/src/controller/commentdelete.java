package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;

@WebServlet("/commentdelete.do")
public class commentdelete extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cId=Integer.parseInt(request.getParameter("cId"));
		int rId=Integer.parseInt(request.getParameter("rId"));
		System.out.println(cId);
//		System.out.println(1);
		
		int result=RestaurantDAO.getInstance().deleteCommentByRestaurantNum(cId);
		
		System.out.println(result);
		response.sendRedirect("ReMeservlet.do?userid="+rId);
	}


}
