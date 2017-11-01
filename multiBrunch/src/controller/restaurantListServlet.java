package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainSearchDao;
import dto.RestaurantDto;

@WebServlet("/result.do")
public class restaurantListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/result.jsp";
		mainSearchDao mDao = mainSearchDao.getInstance();
		List<RestaurantDto> rList = mDao.selectRestaurants();
		
		req.setAttribute("rList", rList);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
	
	
}
