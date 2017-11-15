package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dto.Menu;

@WebServlet("/menumodify.do")
public class MenuModify extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int mId=Integer.parseInt(request.getParameter("mId"));
		int rId=Integer.parseInt(request.getParameter("rId"));
		String mMenu=request.getParameter("mMenu");
		int mPrice=Integer.parseInt(request.getParameter("mPrice"));
		String mPicture1=request.getParameter("mPicture1");
		String mPicture2=request.getParameter("mPicture2");
		
		Menu mVo= new Menu();
		mVo.setmId(mId);
		mVo.setrId(rId);
		mVo.setmName(mMenu);
		mVo.setmPrice(mPrice);
		mVo.setmPicture1(mPicture1);
		mVo.setmPicture2(mPicture2);
		
		int result=MenuDao.getInstance().ModifyMenu(mVo);
		
		response.sendRedirect("ReMeservlet.do?userid="+rId);
	}


}
