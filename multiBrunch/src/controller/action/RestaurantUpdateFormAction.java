package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dto.Restaurant;

public class RestaurantUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/Restaurant/RestaurantUpdate.jsp";
		String rid = request.getParameter("rid");
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		Restaurant rst = bDao.selectOneRestaurantByRid(rid);
		request.setAttribute("Restaurant", rst);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
