package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;


public class UserDao {
	
	private static UserDao instance;
	private Connection conn;

	// 싱글턴 연결
	private UserDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/multiBrunch_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static UserDao getInstance() {
		if (instance == null)
			instance = new UserDao();
		return instance;
	}

	
	// 사용자(이메일)인증
	public int userCheck(String uEmail, String uPassword) {
		int result = -1;
		String sql = "select uPassword from User where uEmail=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uEmail);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("uPassword") != null && rs.getString("uPassword").equals(uPassword)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 사용자(이메일)로 회원 정보 가져오기
	public User selectUser(String uEmail) {
		User uVo = null;
		String sql = "select * from User where uEmail = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				uVo.setuId(rs.getInt("uId"));
				uVo = new User();
				uVo.setuId(rs.getInt("uId"));
				uVo.setuName(rs.getString("uName"));
				uVo.setuEmail(rs.getString("uEmail"));
				uVo.setuPassword(rs.getString("uPassword"));
				uVo.setuGender(rs.getString("uGender"));
				uVo.setuAge(rs.getInt("uAge"));
				uVo.setuPreference(rs.getString("uPreference"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return uVo;
	}

	// 사용자(이메일) 중복 체크
	public int confirmEmail(String uEmail) {
		int result = -1;
		String sql = "select uEmail from User where uEmail=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

	// 회원정보 DB에 추가하기
	public int insertUser(User uVo) {
		int result = -1;
		String sql = "insert into User values(0, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uVo.getuName());
			pstmt.setString(2, uVo.getuEmail());
			pstmt.setString(3, uVo.getuPassword());
			pstmt.setString(4, uVo.getuGender());
			pstmt.setInt(5, uVo.getuAge());
			pstmt.setString(6, uVo.getuPreference());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 회원정보 업데이트
	public int updateUser(User uVo) {
		int result = -1;
		String sql = "update User set uName=?, uPassword=?, uGender=?, uAge=?, uPreference=? where uEmail=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uVo.getuName());
			pstmt.setString(2, uVo.getuPassword());
			pstmt.setString(3, uVo.getuGender());
			pstmt.setInt(4, uVo.getuAge());
			pstmt.setString(5, uVo.getuPreference());
			pstmt.setString(6, uVo.getuEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
