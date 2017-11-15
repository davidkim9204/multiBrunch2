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

public class RestaurantDAO {
	private Connection conn;

	private RestaurantDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/multibrunch_db", "root", "mysql");
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
///////////////////////////////레스토랑 DAO
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
		String sql = "INSERT INTO Restaurant " + "VALUES(0, ?, ?, ?, ?, ?, ?, ?)";
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
	public List<Restaurant> selectChosenRestaurants(String rCategory, int rDistance1, int rDistance2, int mPrice1,
			int mPrice2) {
		String sql = "select * "
				+ "from restaurant r, menu m "
				+ "where r.rId=m.rId and r.rCategory=? and r.rDistance>? and r.rDistance<=? and m.mPrice>? and m.mPrice<=? "
				+ "group by r.rId";
		List<Restaurant> list = new ArrayList<Restaurant>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Restaurant rst = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rCategory);
			pstmt.setInt(2, rDistance1);
			pstmt.setInt(3, rDistance2);
			pstmt.setInt(4, mPrice1);
			pstmt.setInt(5, mPrice2);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrCategory(rs.getString("rCategory"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrOpenHours(rs.getString("rOpenhours"));
				rst.setrTel(rs.getString("rTel"));
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
	public List<Restaurant> selectOneRestaurantByMenu(String mName) {
		List<Restaurant> list = new ArrayList<>();
		String sql = "select * from menu m, restaurant r where r.rid=m.rid and m.mName like ? group by r.rId";
		System.out.println(sql);
		Restaurant rst = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + mName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rst = new Restaurant();
				rst.setrId(rs.getInt("rId"));
				rst.setrName(rs.getString("rName"));
				rst.setrCategory(rs.getString("rCategory"));
				rst.setrAddress(rs.getString("rAddress"));
				rst.setrOpenHours(rs.getString("rOpenhours"));
				rst.setrTel(rs.getString("rTel"));
				rst.setrDistance(rs.getInt("rDistance"));
				rst.setrRate(rs.getInt("rRate"));
				list.add(rst);
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
////////////////메뉴DAO
	
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
	
	
	

	public List<Menu> selectAllMenus() {
		String sql = "select * from menu";
		List<Menu> list = new ArrayList<Menu>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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

	////////////////////////////////////////댓글 DAO
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
