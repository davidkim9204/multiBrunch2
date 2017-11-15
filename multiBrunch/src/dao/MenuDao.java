package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Menu;

public class MenuDao {
	private Connection conn;

	private static MenuDao instance;

	public static MenuDao getInstance() {
		if (instance == null)
			instance = new MenuDao();
		return instance;
	}

	private MenuDao() {
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

	public int insertMenu(Menu mVo) {
		String sql = "INSERT INTO menu VALUES(0,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getmName());
			pstmt.setInt(2, mVo.getmPrice());
			pstmt.setString(3,mVo.getmPicture1());
			pstmt.setString(4, mVo.getmPicture2());
			pstmt.setInt(5, mVo.getrId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMenu(int rId, String mName) {
		String sql = "DELETE FROM menu WHERE rId = ? AND mName = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			pstmt.setString(2, mName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int ModifyMenu(Menu mVo) {
		String sql = "update menu set mName=?, mPrice=?, mPicture1=?, "
				+ "mPicture2=?, rId=? where mId=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getmName());
			pstmt.setInt(2, mVo.getmPrice());
			pstmt.setString(3, mVo.getmPicture1());
			pstmt.setString(4, mVo.getmPicture2());
			pstmt.setInt(5, mVo.getmId());
			pstmt.setInt(6, mVo.getmId());
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
