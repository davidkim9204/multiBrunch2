/*package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

public class CommentDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid = Integer.parseInt(request.getParameter("cid"));
		int num = Integer.parseInt(request.getParameter("RestaurantNum"));
		CommentDao.getInstance().deleteComment(cid);
		
		response.sendRedirect("RestaurantServlet?command=Restaurant_view&num="
		+num);
	}

}
*/