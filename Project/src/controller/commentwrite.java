package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;
import dto.Comment;

@WebServlet("/commentwrite.do")
public class commentwrite extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DB pDao =DB.getInstance();
		
		Comment com = new Comment();
		com.setuId(Integer.parseInt(request.getParameter("uId")));
		com.setcContents(request.getParameter("comment"));
		com.setcRate(Integer.parseInt(request.getParameter("Rate")));
		String k=request.getParameter("rName");
		int rName=Integer.parseInt(k);
//		System.out.println(rName);
		com.setrId(rName);
		
//		System.out.println(com.getrId());
//		System.out.println(Integer.parseInt(request.getParameter("uId")));
//		System.out.println(request.getParameter("comment"));
//		System.out.println(Integer.parseInt(request.getParameter("Rate")));
		
		int result=DB.getInstance().insertComment(com);
		
//		System.out.println(result);
		response.sendRedirect("ReMeservlet.do?userid="+rName);
		
	}


}
