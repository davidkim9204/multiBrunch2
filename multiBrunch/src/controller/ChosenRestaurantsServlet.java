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

@WebServlet("/ChosenRestaurantsServlet")
public class ChosenRestaurantsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/result.jsp";
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		List<Restaurant> RestaurantList = bDao.selectChosenRestaurants("kor",100,5000);
		req.setAttribute("RestaurantList", RestaurantList);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
