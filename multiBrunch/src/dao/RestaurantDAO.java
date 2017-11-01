package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.Restaurant;

public class RestaurantDAO {
	private Connection conn;
	private RestaurantDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/multibrunch_db","root","mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static RestaurantDAO instance = new RestaurantDAO();

	public static RestaurantDAO getInstance() {
		return instance;
	}

	public List<Restaurant> selectAllRestaurants() {
		String sql = "SELECT * FROM Restaurant ORDER BY rid DESC";
		List<Restaurant> list = new ArrayList<Restaurant>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Restaurant rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrOpenhours(rs.getString("rOpenhours"));
				rst.setrTel(rs.getString("rTel"));
				rst.setrRate(rs.getInt("rRate"));
				rst.setrCategory(rs.getString("rCategory"));
				list.add(rst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return list;
	}

	public void insertRestaurant(Restaurant rst) {
		String sql = "INSERT INTO Restaurant "
				+ "VALUES(0, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rst.getrName());
			pstmt.setString(2, rst.getrAddress());
			pstmt.setInt(3, rst.getrDistance());
			pstmt.setString(4, rst.getrOpenhours());
			pstmt.setString(5, rst.getrTel());
			pstmt.setInt(6, rst.getrRate());
			pstmt.setString(7, rst.getrCategory());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public Restaurant selectOneRestaurantByRid(String rid) {
		String sql = "SELECT * FROM Restaurant WHERE rid = ?";
		Restaurant rst = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrOpenhours(rs.getString("rOpenhours"));
				rst.setrTel(rs.getString("rTel"));
				rst.setrRate(rs.getInt("rRate"));
				rst.setrCategory(rs.getString("rCategory"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return rst;
	}

	public void updateRestaurant(Restaurant rst) {
		String sql = "UPDATE Restaurant SET rName=?, rAddress=?, rDistance=?, "
				+ "rOpenhours=?, rTel=?, rRate=?, rCategory=? where rid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rst.getrName());
			pstmt.setString(2, rst.getrAddress());
			pstmt.setInt(3, rst.getrDistance());
			pstmt.setString(4, rst.getrOpenhours());
			pstmt.setString(5, rst.getrTel());
			pstmt.setInt(6, rst.getrRate());
			pstmt.setString(7, rst.getrCategory());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}


	public void deleteRestaurant(String rid) {
		String sql = "DELETE FROM Restaurant WHERE rid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
