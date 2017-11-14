package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.makeRandomRestaurantList;
import dao.RestaurantDAO;
import dto.Restaurant;

public class RestaurantListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/Restaurant/RestaurantList.jsp";
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		List<Restaurant> RestaurantList = bDao.selectAllRestaurants();
		request.setAttribute("RestaurantList", RestaurantList);
		
		makeRandomRestaurantList randomRestaurant;
		randomRestaurant = new makeRandomRestaurantList();
		int r = randomRestaurant.getRandomRestaurantId();
		request.setAttribute("randomRestaurant", r);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
