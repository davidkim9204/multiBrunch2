package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public int insertComment(Comment cVo) {
		String sql = "INSERT INTO comment VALUES(0,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cVo.getNum());
			pstmt.setString(2, cVo.getContent());
			pstmt.setString(3, cVo.getWriter());
			pstmt.setInt(4, cVo.getRestaurantNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null )
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
	// 하나의 커멘트를 삭제하는 기능
	public int deleteComment(int cId){
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
				if( pstmt != null )
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	
	}

	// 하나의 게시물에 대한 모든 커멘트를 얻어오는 기능
	public List<Comment> selectAllComments(int RestaurantNum){
		String sql = "SELECT * FROM comment WHERE c_Restaurant_num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, RestaurantNum);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Comment cVo = new Comment();
				cVo.setId(rs.getInt("c_id"));
				cVo.setNum(rs.getInt("c_num"));
				cVo.setContent(rs.getString("c_content"));
				cVo.setWriter(rs.getString("c_writer"));
				cVo.setRestaurantNum(rs.getInt("c_Restaurant_num"));
				list.add(cVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
	
	

	// 하나의 게시물에 대한 모든 커멘트를 삭제하는 기능
	public int deleteCommentByRestaurantNum(int RestaurantNum){
		String sql = "DELETE FROM comment WHERE c_Restaurant_num = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,RestaurantNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null )
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	
	}
	
	

	// 하나의 게시물에 대해 가장 큰 댓글번호를 얻어오는 기능
	public int getMaxNumComment(int RestaurantNum) {
		String sql = "SELECT MAX(c_num) FROM comment WHERE c_Restaurant_num = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxNum = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, RestaurantNum);
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
