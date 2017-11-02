package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;
import dto.Restaurant;

public class compare3dao {

	private Connection conn;

	private static compare3dao instance;

	public static compare3dao getInstance() {
		if (instance == null)
			instance = new compare3dao();
		return instance;
	}

	private compare3dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/multibrunch_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Restaurant selectOneRestaurantByNum(int rId) {
		String sql = "select * from Restaurant where rid = ?";
		Restaurant r = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				r = new Restaurant();
				r.setrId(rs.getInt("rId"));
				r.setrName(rs.getString("rName"));
				r.setrDistance(rs.getInt("rDistance"));
				r.setrRate(rs.getInt("rRate"));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return r;
	}

	public List<Menu> selectOneMenuByNum(int rId) {
		List<Menu> list = new ArrayList<>();
		String sql = "select * from Menu where rId = ?";
		Menu m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				m = new Menu();
				m.setmId(rs.getInt("mId"));
				m.setmPicture1(rs.getString("mPicture1"));
				m.setmName(rs.getString("mName"));
				list.add(m);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

}