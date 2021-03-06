package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dto.Comment;

@WebServlet("/commentwrite.do")
public class commentwrite extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RestaurantDAO pDao =RestaurantDAO.getInstance();
		
		Comment com = new Comment();
		com.setuId(Integer.parseInt(request.getParameter("uId")));
		com.setcContents(request.getParameter("comment"));
		com.setcRate(Integer.parseInt(request.getParameter("Rate")));
		String k=request.getParameter("rName");
		int rName=Integer.parseInt(k);
		
		com.setrId(rName);
		System.out.println(com.getuId());
		
		int result=RestaurantDAO.getInstance().insertComment(com);
	
		response.sendRedirect("ReMeservlet.do?rid="+rName+"&uId="+com.getuId());
		
	}


}
