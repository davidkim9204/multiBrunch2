package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dao.CommentDao;
import dto.CommentVO;
import dto.Restaurant;

public class RestaurantViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/Restaurant/RestaurantView.jsp";
		String rid = request.getParameter("rid");
		
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		Restaurant rst = bDao.selectOneRestaurantByRid(rid);
		List<CommentVO> list = CommentDao.getInstance()
				.selectAllComments(Integer.parseInt(rid));
		
		request.setAttribute("Restaurant", rst);
		request.setAttribute("commentList", list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
