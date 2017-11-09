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
import dto.Restaurant;

@WebServlet("/index.do")
public class mainSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		List<Restaurant> RestaurantList = bDao.selectAllRestaurants();
		List<Restaurant> resultRestaurantList = new ArrayList<>();
		resultRestaurantList.add(RestaurantList.get(0));
		resultRestaurantList.add(RestaurantList.get(1));
		resultRestaurantList.add(RestaurantList.get(2));
		resultRestaurantList.add(RestaurantList.get(3));
		resultRestaurantList.add(RestaurantList.get(4));
		// resultRestaurantList.add(RestaurantList.get(0).getrName().toString());

		req.setAttribute("resultRestaurantList", resultRestaurantList);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}