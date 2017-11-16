package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;
import dto.Comment;

@WebServlet("/commentdelete.do")
public class commentdelete extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cId=Integer.parseInt(request.getParameter("cId"));
		int rId=Integer.parseInt(request.getParameter("rId"));
		int uId=Integer.parseInt(request.getParameter("uId"));
			
		Comment cVo =new Comment();
		cVo=DB.getInstance().selectOneComment(cId);
		
		if(cVo.getuId()==uId) {
			int result=DB.getInstance().deleteComment(cId);
			response.sendRedirect("ReMeservlet.do?rid="+rId+"&uId="+uId);
		}
		else {
			response.sendRedirect("ReMeservlet.do?rid="+rId+"&uId="+uId);
		}
		
		
//		int result=DB.getInstance().deleteComment(cId);
//		
//		System.out.println(result);
//		response.sendRedirect("ReMeservlet.do?rid="+rId+"&uId="+uId);
	}


}
