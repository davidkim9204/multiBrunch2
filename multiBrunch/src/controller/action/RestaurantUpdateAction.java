package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dto.Restaurant;

public class RestaurantUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Restaurant rst = new Restaurant();
		rst.setrId(Integer.parseInt(request.getParameter("rId")));
		rst.setrName(request.getParameter("rName"));
		rst.setrAddress(request.getParameter("rAddress"));
		rst.setrDistance(Integer.parseInt(request.getParameter("rDistance")));
		rst.setrTel(request.getParameter("rTel"));
		rst.setrRate(Integer.parseInt(request.getParameter("rRate")));
		rst.setrCategory(request.getParameter("rCategory"));
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		bDao.updateRestaurant(rst);
		new RestaurantListAction().execute(request, response);
	}
}
