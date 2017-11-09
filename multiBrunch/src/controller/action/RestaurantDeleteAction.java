package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dao.CommentDao;

public class RestaurantDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid=request.getParameter("rid");
		RestaurantDAO bDao=RestaurantDAO.getInstance();
		bDao.deleteRestaurant(rid);
		CommentDao.getInstance().deleteCommentByRestaurantNum(
				Integer.parseInt(rid));
		
		new RestaurantListAction().execute(request, response);
	}
}
