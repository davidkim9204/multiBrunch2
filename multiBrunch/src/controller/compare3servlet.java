package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.compare3dao;
import dto.Menu;
import dto.Restaurant;


@WebServlet("/minyoungservlet.do")
public class compare3servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		resp.setContentType("text/html;charset=UTF-8");	
		
		
		int num=Integer.parseInt(req.getParameter("userid"));
		
		
		
		compare3dao d =compare3dao.getInstance();
		
		Restaurant r = d.selectOneRestaurantByNum(num);
		List<Menu> m = d.selectOneMenuByNum(r.getrId());

		
		
		req.setAttribute("Restaurant", r);
		req.setAttribute("Menu", m);
		for(Menu mm : m )
			System.out.println(m);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("compare3.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}