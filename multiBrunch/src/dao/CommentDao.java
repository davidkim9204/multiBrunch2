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

public class CommentDao {
	private static CommentDao instance;
	private Connection conn;

	private CommentDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Restaurant_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CommentDao getInstance() {
		if (instance == null)
			instance = new CommentDao();
		return instance;
	}

	// 하나의 커멘트를 삽입하는 기능
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
		System.out.println(list);
		return list;
	}

	/*public List<Comment> selectAllComment() {
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
	}*/

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

//	// 하나의 커멘트를 삭제하는 기능
	public int deleteCommentByRestaurantNum(int cId) {
		String sql = "DELETE FROM comment WHERE c_id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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

}
