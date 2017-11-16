package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;

@WebServlet("/menudelete.do")
public class MenuDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mName=request.getParameter("mMenu");
		int rId=Integer.parseInt(request.getParameter("rId"));
		
//		System.out.println(mMenu);
//		System.out.println(rId);
		
		int result=DB.getInstance().deleteMenu(rId, mName);
		
//		System.out.println(result);
		response.sendRedirect("ReMeservlet.do?userid="+rId);
	}


}
