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
		List<Restaurant> popularRestaurantList = new ArrayList<>();
		List<Restaurant> recommendRestaurantList = new ArrayList<>();
		
		//popular랑 recommend랑 조건 줘서 popular는 평점 순으로 정렬해서 보내고 recommend는 그냥 랜덤 값으로 보내자?
		for(int i=0;i<5;i++){
			popularRestaurantList.add(RestaurantList.get(i));
		}
		for(int i=0;i<5;i++){
			recommendRestaurantList.add(RestaurantList.get(i));
		}
		
		req.setAttribute("popularRestaurantList", popularRestaurantList);
		req.setAttribute("recommendRestaurantList", recommendRestaurantList);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}