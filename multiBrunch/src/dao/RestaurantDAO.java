package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;
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
				rst.setrOpenHours(rs.getString("rOpenHours"));
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
			pstmt.setString(4, rst.getrOpenHours());
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
	public Restaurant selectOneRestaurantByRid(String value) {
		String sql = "SELECT * FROM Restaurant WHERE rid = ?";
		Restaurant rst = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
					
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrOpenHours(rs.getString("rOpenHours"));
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
	
	public Restaurant selectOneRestaurantByInt(int rId) {
		String sql = "SELECT * FROM Restaurant WHERE rid = ?";
		Restaurant rst = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrOpenHours(rs.getString("rOpenHours"));
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
			pstmt.setString(4, rst.getrOpenHours());
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
	
	public List<Menu> selectOneBoardByNum(int rId) {
		String sql = "select * from menu where rId = ?";
		List<Menu> list = new ArrayList<Menu>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Menu bVo = new Menu();
				bVo.setmId(rs.getInt("mId"));
				bVo.setmName(rs.getString("mName"));
				bVo.setmPrice(rs.getInt("mPrice"));
				bVo.setmPicture1(rs.getString("mPicture1"));
				bVo.setmPicture2(rs.getString("mPicture2"));
//				bVo.setmPrice(rs.getInt("rId"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println(list);
		return list;
	}
	
	public List<Restaurant> selectChosenRestaurants(String rCategory, int rDistance, int mPrice){
		String sql = "select r.rId, r.rName, rCategory, r.rDistance, r.rRate from restaurant r, menu m "
				+ "where r.rCategory=? and r.rDistance=? and m.mPrice=?";
		List<Restaurant> list = new ArrayList<Restaurant>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Restaurant rst = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rCategory);
			pstmt.setInt(2, rDistance);
			pstmt.setInt(3, mPrice);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrCategory(rs.getString("rCategory"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrRate(rs.getInt("rRate"));
				list.add(rst);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	

	
	
}
