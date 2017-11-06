package controller;

import java.io.IOException;
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
		Restaurant rst = new Restaurant();
		Menu menu = new Menu();
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		String category = req.getParameter("categorySelect");
		int distance = Integer.parseInt(req.getParameter("distanceSelect"));
		int price = Integer.parseInt(req.getParameter("priceSelect"));
		System.out.println(category+distance+price);
		
		List<Restaurant> RestaurantList = bDao.selectChosenRestaurants(category,distance,price);
		req.setAttribute("RestaurantList", RestaurantList);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
