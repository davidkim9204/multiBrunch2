package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dto.CommentVO;

public class CommentWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//넘어오는 파라미터를 먼저 줏어보죠
		CommentVO cVo = new CommentVO();
		cVo.setContent(request.getParameter("content"));
		cVo.setWriter(request.getParameter("writer"));
		cVo.setRestaurantNum(Integer.parseInt(
				request.getParameter("RestaurantNum")));
		
		//현재 게시글의 가장 큰 댓글넘버를 얻어와서
		int maxNum = 
				CommentDao.getInstance().getMaxNumComment(
						cVo.getRestaurantNum());
		//하나 늘려서 박고
		cVo.setNum(maxNum + 1);
		//디비에 삽입
		CommentDao.getInstance().insertComment(cVo);
		//해당 게시글의 Restaurant_view로 리다이렉트
		response
		.sendRedirect("RestaurantServlet?command=Restaurant_view&num="
		+cVo.getRestaurantNum());
	}

}
