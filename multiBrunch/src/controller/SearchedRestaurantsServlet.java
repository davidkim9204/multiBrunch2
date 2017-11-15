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
import dto.Restaurant;

@WebServlet("/SearchedRestaurantsServlet")
public class SearchedRestaurantsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/result.jsp";
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		String searchedMenu = req.getParameter("m.mName");
		
		List<Restaurant> RestaurantList = bDao.selectOneRestaurantByMenu(searchedMenu);
		
		System.out.println(RestaurantList);
		req.setAttribute("RestaurantList", RestaurantList);
		
		makeRandomRestaurantList randomRestaurant;
		randomRestaurant = new makeRandomRestaurantList();
		int r = randomRestaurant.getRandomRestaurantId();
		req.setAttribute("randomRestaurant", r);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
}
