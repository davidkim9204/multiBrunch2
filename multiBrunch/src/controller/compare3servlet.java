package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestaurantDAO;
import dto.Menu;
import dto.Restaurant;

@WebServlet("/compareservlet.do")
public class compare3servlet extends HttpServlet {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // TODO Auto-generated method stub
      // super.doGet(req, resp);

      resp.setContentType("text/html;charset=UTF-8");

      // int num=Integer.parseInt(req.getParameter("userid"));
      //
      // RestaurantDAO d =RestaurantDAO.getInstance();
      //
      // Restaurant rst = d.selectOneRestaurantByInt(num);
      // List<Menu> m = d.selectOneMenuByNum(rst.getrId());

      String[] value = req.getParameterValues("comsel");
      List<Menu> MenuList = null;
      List<Menu> returnMenuList = null;
      Restaurant rst = null;
      List<Restaurant> restaurantList = new ArrayList<>();
      for (int i = 0; i < value.length; i++) {
         RestaurantDAO d = RestaurantDAO.getInstance();
         returnMenuList = new ArrayList<>();
         rst = d.selectOneRestaurantByRid(value[i]);
         MenuList = d.selectOneMenuByNum(rst.getrId());
         restaurantList.add(rst);
         returnMenuList.addAll(MenuList);
         System.out.println(MenuList);
      }
      req.setAttribute("Restaurant", restaurantList);
      req.setAttribute("Menu", returnMenuList);

      // for(String val : value) {
      // RestaurantDAO d =RestaurantDAO.getInstance();
      // Restaurant rst0 = d.selectOneRestaurantByRid(value[0]);
      // List<Menu> m0 = d.selectOneMenuByNum(rst0.getrId());
      // Restaurant rst1 = d.selectOneRestaurantByRid(value[1]);
      // List<Menu> m1 = d.selectOneMenuByNum(rst1.getrId());
      // Restaurant rst2 = d.selectOneRestaurantByRid(value[2]);
      // List<Menu> m2 = d.selectOneMenuByNum(rst2.getrId());
      // req.setAttribute("Restaurant1", rst0);
      // req.setAttribute("Menu1", m0);
      // req.setAttribute("Restaurant2", rst1);
      // req.setAttribute("Menu2", m1);
      // req.setAttribute("Restaurant3", rst2);
      // req.setAttribute("Menu3", m2);
      // }

      // for(Menu mm : m )
      // System.out.println(m);
      
      makeRandomRestaurantList randomRestaurant;
		randomRestaurant = new makeRandomRestaurantList();
		int r = randomRestaurant.getRandomRestaurantId();
		req.setAttribute("randomRestaurant", r);
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("compare3.jsp");
      dispatcher.forward(req, resp);

   

   }

}