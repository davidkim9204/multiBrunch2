package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RestaurantDAO;
import dto.Restaurant;
import dto.User;

@WebServlet("/index.do")
public class mainSearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		List<Restaurant> RestaurantList = bDao.selectAllRestaurants();
		List<Restaurant> popularRestaurantList = new ArrayList<>();
		List<Restaurant> recommendRestaurantList = new ArrayList<>();
		Random random = new Random();
		MiniComparator comp = new MiniComparator();
		Collections.sort(RestaurantList, comp);
		makeRandomRestaurantList randomRestaurant;
		randomRestaurant = new makeRandomRestaurantList();
		int r = randomRestaurant.getRandomRestaurantId();


		// popular랑 recommend랑 조건 줘서 popular는 평점 순으로 정렬해서 보내고 recommend는 그냥 랜덤
		// 값으로 보내자?
		for (int i = 0; i < 5; i++) {
			popularRestaurantList.add(RestaurantList.get(i));
		}
		
		while(recommendRestaurantList.size()<5){
			int a = random.nextInt(RestaurantList.size());
			if(!recommendRestaurantList.contains(RestaurantList.get(a))){
				recommendRestaurantList.add(RestaurantList.get(a));
			}
		}
		
		req.setAttribute("popularRestaurantList", popularRestaurantList);
		req.setAttribute("recommendRestaurantList", recommendRestaurantList);
		req.setAttribute("randomRestaurant", r);
		HttpSession session = req.getSession();
		if(session.getAttribute("loginUser") == null) {
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("login_main.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAO bDao = RestaurantDAO.getInstance();
		List<Restaurant> RestaurantList = bDao.selectAllRestaurants();
		List<Restaurant> popularRestaurantList = new ArrayList<>();
		List<Restaurant> recommendRestaurantList = new ArrayList<>();
		Random random = new Random();
		//HttpSession session = req.getSession(false);
		//User user = (User) session.getAttribute("uId");
		MiniComparator comp = new MiniComparator();
		Collections.sort(RestaurantList, comp);
		//List<Restaurant> randomRestaurantList = new ArrayList<>();
		makeRandomRestaurantList randomRestaurant;
		randomRestaurant = new makeRandomRestaurantList();
		int r = randomRestaurant.getRandomRestaurantId();

		// popular랑 recommend랑 조건 줘서 popular는 평점 순으로 정렬해서 보내고 recommend는 그냥 랜덤
		// 값으로 보내자?
		for (int i = 0; i < 5; i++) {
			popularRestaurantList.add(RestaurantList.get(i));
		}
		
		while(recommendRestaurantList.size()<5){
			int a = random.nextInt(RestaurantList.size());
			if(!recommendRestaurantList.contains(RestaurantList.get(a))){
				recommendRestaurantList.add(RestaurantList.get(a));
			}
		}

		req.setAttribute("popularRestaurantList", popularRestaurantList);
		req.setAttribute("recommendRestaurantList", recommendRestaurantList);
		req.setAttribute("randomRestaurant", r);
		resp.sendRedirect("index.do");
		//req.getRequestDispatcher("login_main.jsp").forward(req, resp);
	}

}


class MiniComparator implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant first, Restaurant second) {
		int firstValue = first.getrRate();
		int secondValue = second.getrRate();
		if (firstValue > secondValue) {
			return -1;
		} else if (firstValue < secondValue) {
			return 1;
		} else {
			return 0;
		}
	}

}




