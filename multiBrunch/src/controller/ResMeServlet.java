package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;
import dto.Comment;
import dto.Menu;
import dto.Restaurant;

@WebServlet("/ReMeservlet.do")
public class ResMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");	
		
		int num=Integer.parseInt(request.getParameter("userid"));
		
		DB pDao =DB.getInstance();
		
		Restaurant resvo =pDao.selectOneRestaurantByNum(num);
		List<Menu> Menulist =pDao.selectOneBoardByNum(resvo.getrId());
		List<Comment> commentlist = pDao.selectAllComment();
		
//		for(Comment c : commentlist) 
//			System.out.println(c.getcId()+" "+c.getcContents()+ " "+ c.getcRate());
		
		request.setAttribute("commentlist", commentlist);
		request.setAttribute("menulist", Menulist);
		request.setAttribute("Restaurant", resvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ReMedetail.jsp");
		dispatcher.forward(request, response);
	
	
	}


}
