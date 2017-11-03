package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Restaurant;


public class mainSearchDao {
	private Connection conn;

	private mainSearchDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/multibrunch_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static mainSearchDao instance = new mainSearchDao();

	public static mainSearchDao getInstance() {
		return instance;
	}

	public List<Restaurant> selectRestaurants() {
		String sql = "select * from restaurant";
		List<Restaurant> list = new ArrayList<Restaurant>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Restaurant rDTO = new Restaurant();
				rDTO.setrId(rs.getInt("rId"));
				rDTO.setrName(rs.getString("rName"));
				rDTO.setrAddress(rs.getString("rAddress"));
				rDTO.setrDistance(rs.getInt("rDistance"));
				rDTO.setrOpenHours(rs.getString("rOpenHours"));
				rDTO.setrTel(rs.getString("rTel"));
				rDTO.setrRate(rs.getInt("rRate"));
				list.add(rDTO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	

}
