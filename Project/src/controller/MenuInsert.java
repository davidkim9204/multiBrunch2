package controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;
import dto.Menu;
import dto.Restaurant;

@WebServlet("/menuinsert.do")
public class MenuInsert extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rId=Integer.parseInt(request.getParameter("rId"));
		String mMenu=request.getParameter("mMenu");
		int mPrice=Integer.parseInt(request.getParameter("mPrice"));
		String mPicture1=request.getParameter("mPicture1");
		String mPicture2=request.getParameter("mPicture2");
		
		DB pDao =DB.getInstance();
		
		Menu mVo = new Menu();
		mVo.setrId(rId);
		mVo.setmName(mMenu);
		mVo.setmPrice(mPrice);
		mVo.setmPicture1(mPicture1);
		mVo.setmPicture2(mPicture2);
		
		int result=DB.getInstance().insertMenu(mVo);
		
		System.out.println(result);
		
		response.sendRedirect("ReMeservlet.do?userid="+rId);
		
//		Menu MenurId = new Menu();
//		
//		MenurId.setrId(rId);
//		
//		request.setAttribute("menurId", MenurId);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("MenuInsert.jsp");
//		dispatcher.forward(request, response);
		
		
		
//		System.out.println(rId);
		
//		Scanner input = new Scanner(System.in);
		
	/*	String Name=input.next();
		int Price = input.nextInt();
		String Picture1 =input.next();
		String Picture2 =input.next();*/
		
//		System.out.println(Name);
//		System.out.println(Price);
//		System.out.println(Picture1);
//		System.out.println(Picture2);
		
	/*	Menu mVo = new Menu();
		
		mVo.setmName(Name);
		mVo.setmPrice(Price);
		mVo.setmPicture1(Picture1);
		mVo.setmPicture2(Picture2);
		mVo.setrId(rId);
		
		DB pDao =DB.getInstance();
		
		int result=DB.getInstance().insertMenu(mVo);
		
		System.out.println(result);
		
		response.sendRedirect("ReMeservlet.do?userid="+rId);*/
		
	}


}
