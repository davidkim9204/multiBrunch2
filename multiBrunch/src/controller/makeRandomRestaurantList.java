package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.RestaurantDAO;
import dto.Restaurant;

public class makeRandomRestaurantList {
	RestaurantDAO bDao = RestaurantDAO.getInstance();
	List<Restaurant> RestaurantList = bDao.selectAllRestaurants();
	List<Restaurant> randomRestaurantList = new ArrayList<>();
	Random random = new Random();
	int a = random.nextInt(RestaurantList.size());

	public int getRandomRestaurantId() {
		int a = random.nextInt(RestaurantList.size());
		randomRestaurantList.add(RestaurantList.get(a));
		return randomRestaurantList.get(0).getrId();

	}

}

