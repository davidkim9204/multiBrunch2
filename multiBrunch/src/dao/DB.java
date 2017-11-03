package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.MenuDto;
import dto.RestaurantDto;

public class DB {
	private Connection conn;

	private static DB instance;

	public static DB getInstance() {
		if (instance == null)
			instance = new DB();
		return instance;
	}

	private DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/multibrunch_db", "root", "890128");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//메뉴 리스트에 담기	
		public List<MenuDto> selectOneBoardByNum(int rId) {
			String sql = "select * from menu where rId = ?";
			List<MenuDto> list = new ArrayList<MenuDto>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rId);
				rs = pstmt.executeQuery();
				while (rs.next()){
					MenuDto bVo = new MenuDto();
					bVo.setmId(rs.getInt("mId"));
					bVo.setmName(rs.getString("mName"));
					bVo.setmPrice(rs.getInt("mPrice"));
					bVo.setmPicture1(rs.getString("mPicture1"));
					bVo.setmPicture2(rs.getString("mPicture2"));
//					bVo.setmPrice(rs.getInt("rId"));
					list.add(bVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
			System.out.println(list);
			return list;
		}
	
	
//	public Menu selectOneBoardByNum(int rId) {
//		String sql = "select * from menu where rId = ?";
//		Menu bVo = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, rId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new Menu();
//				bVo.setmId(rs.getInt("mId"));
//				bVo.setmName(rs.getString("mName"));
//				bVo.setmPrice(rs.getInt("mPrice"));
//				bVo.setmPicture1(rs.getString("mPicture1"));
//				bVo.setmPicture2(rs.getString("mPicture2"));
////				bVo.setmPrice(rs.getInt("rId"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//		}
//		return bVo;
//	}

	public RestaurantDto selectOneRestaurantByNum(int rId) {
		String sql = "select * from restaurant where rId = ?";
		RestaurantDto bVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new RestaurantDto();

				bVo.setrId(rs.getInt("rId"));
				bVo.setrName(rs.getString("rName"));
				bVo.setrAddress(rs.getString("rAddress"));
				bVo.setrDistance(rs.getInt("rDistance"));
				bVo.setrOpenHours(rs.getString("rOpenHours"));
				bVo.setrTel(rs.getString("rTel"));
				bVo.setrRate(rs.getInt("rRate"));
				bVo.setrCategory(rs.getString("rCategory"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return bVo;
	}

}
