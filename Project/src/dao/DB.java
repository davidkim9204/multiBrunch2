package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Comment;
import dto.Menu;
import dto.Restaurant;

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

	// 메뉴 리스트에 담기
	public List<Menu> selectOneBoardByNum(int rId) {
		String sql = "select * from menu where rId = ?";
		List<Menu> list = new ArrayList<Menu>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Menu bVo = new Menu();
				bVo.setmId(rs.getInt("mId"));
				bVo.setmName(rs.getString("mName"));
				bVo.setmPrice(rs.getInt("mPrice"));
				bVo.setmPicture1(rs.getString("mPicture1"));
				bVo.setmPicture2(rs.getString("mPicture2"));
				// bVo.setmPrice(rs.getInt("rId"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println(list);
		return list;
	}

	// public Menu selectOneBoardByNum(int rId) {
	// String sql = "select * from menu where rId = ?";
	// Menu bVo = null;
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	// try {
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setInt(1, rId);
	// rs = pstmt.executeQuery();
	// if (rs.next()) {
	// bVo = new Menu();
	// bVo.setmId(rs.getInt("mId"));
	// bVo.setmName(rs.getString("mName"));
	// bVo.setmPrice(rs.getInt("mPrice"));
	// bVo.setmPicture1(rs.getString("mPicture1"));
	// bVo.setmPicture2(rs.getString("mPicture2"));
	//// bVo.setmPrice(rs.getInt("rId"));
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// }
	// return bVo;
	// }

	public Restaurant selectOneRestaurantByNum(int rId) {
		String sql = "select * from restaurant where rId = ?";
		Restaurant bVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new Restaurant();

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

	// ---------------------------------댓글-------------------------------------------------------------
	public List<Comment> selectComment(int rId) {
		String sql = "select * from comment where rId = ?";
		List<Comment> list = new ArrayList<Comment>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment bVo = new Comment();
				bVo.setcId(rs.getInt("cId"));
				bVo.setcContents(rs.getString("cContents"));
				bVo.setcRate(rs.getInt("cRate"));
				bVo.setuId(rs.getInt("uId"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
//		System.out.println(list);
		return list;
	}

	public List<Comment> selectAllComment() {
		String sql = "select * from comment order by cId desc";
		List<Comment> list = new ArrayList<Comment>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Comment bVo = new Comment();

				bVo.setcId(rs.getInt("cId"));
				bVo.setcContents(rs.getString("cContents"));
				bVo.setcRate(rs.getInt("cRate"));
				bVo.setuId(rs.getInt("uId"));
				bVo.setuId(rs.getInt("rId"));
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return list;
	}

	// 하나의 커멘트를 삽입하는 기능
	public int insertComment(Comment cVo) {
		String sql = "INSERT INTO comment VALUES(0,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cVo.getcContents());
			pstmt.setInt(2, cVo.getcRate());
			pstmt.setInt(3, cVo.getuId());
			pstmt.setInt(4, cVo.getrId());
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

	// 하나의 커멘트를 삭제하는 기능
	public int deleteComment(int cId) {
		String sql = "DELETE FROM comment WHERE cId = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
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
	
	public int getMaxNumComment(int boardNum) {
		String sql = "SELECT MAX(c_num) FROM comment WHERE cId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxNum = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if (rs.next())
				maxNum = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return maxNum;
	}
	
//----------------------------------메뉴-------------------------------
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
			pstmt.setInt(5, mVo.getrId());
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
