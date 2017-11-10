package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dto.Menu;
import dto.Restaurant;

@WebServlet("/ChosenRestaurantsServlet")
public class ChosenRestaurantsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/result.jsp";
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		String category = req.getParameter("categorySelect");
		int distance1 = Integer.parseInt(req.getParameter("distanceSelect"))-100;
		int distance2 = Integer.parseInt(req.getParameter("distanceSelect"));
		int price1 = Integer.parseInt(req.getParameter("priceSelect"))-5000;
		int price2 =  Integer.parseInt(req.getParameter("priceSelect"));
		if(distance2==0){
			distance1=0;
			distance2=400;
		}
		if(price2==0){
			price1=0;
			price2=20000;
		}
		List<Restaurant> RestaurantList = bDao.selectChosenRestaurants(category,distance1,distance2,price1,price2);
		req.setAttribute("RestaurantList", RestaurantList);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
}
