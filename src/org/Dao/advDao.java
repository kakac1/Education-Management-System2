package org.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.User.entity.Advise;

public class advDao {
	public static int addAdv(Advise advise) {// 增加建议信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "insert into advise(id,建议,电话号码,匿名身份) values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, advise.getAdv());
			pstmt.setString(2, advise.getTelnumber());
			pstmt.setString(3, advise.getSf());
			int count = pstmt.executeUpdate();// 执行后返回执行数据
			if (count > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return 1;
	}

	public static boolean Deladv(int id) {// 删除建议信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "delete  from advise where id='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return true;
	}

	public static boolean updateadv(Advise advise) {// 修改建议
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "update advise set 建议=?where id='" + advise.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, advise.getAdv());

			int count = pstmt.executeUpdate();// 执行后返回执行数据
			System.out.print(advise);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public static boolean existadv(int id) {// 是否存在true/false
		return Queryadv(id) == null ? false : true;
	}

	public static Advise Queryadv(int id) {// 查询建议
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Advise adv = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from advise where id='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String advise = (rs.getString("建议"));
				String Number = (rs.getString("电话号码"));
				String Sf = (rs.getString("匿名身份"));
				adv = new Advise(id1, advise, Number, Sf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return adv;
	}

	public static List<Advise> Queryalladv() {// 查询所有建议
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Advise> advlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from advise ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			advlist = new ArrayList<Advise>();
			while (rs.next()) {
				Advise adv = null;
				int id1 = (rs.getInt("id"));
				String advise = (rs.getString("建议"));
				String Number = (rs.getString("电话号码"));
				String Sf = (rs.getString("匿名身份"));
				adv = new Advise(id1, advise, Number, Sf);
				advlist.add(adv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return advlist;

	}
	public static List<Advise> Queryalladv(String page_num) {// 查询所有建议，按页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Advise> advlist = null;
		int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
		int al_page=10;//每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from advise limit "+startpage+","+al_page+"";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			advlist = new ArrayList<Advise>();
			while (rs.next()) {
				Advise adv = null;
				int id1 = (rs.getInt("id"));
				String advise = (rs.getString("建议"));
				String Number = (rs.getString("电话号码"));
				String Sf = (rs.getString("匿名身份"));
				adv = new Advise(id1, advise, Number, Sf);
				advlist.add(adv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return advlist;

	}
	
	public static int Queryalladv_num() {// 查询所有建议页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Advise> advlist = null;
		int count=0;
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) as count from advise ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			advlist = new ArrayList<Advise>();
			if (rs.next()) {
				count=rs.getInt("count");
			}

			if (count % 10 == 0) {
				count /= 10;

			} else if (count % 10 != 0) {
				count = count / 10 + 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return count;

	}
	
	
	
	

	public static List<Advise> Queryalladv_sf(String sf) {// 查询所有相同身份建议
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Advise> advlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from advise where 匿名身份='" + sf + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			advlist = new ArrayList<Advise>();
			while (rs.next()) {
				Advise adv = null;
				int id1 = (rs.getInt("id"));
				String advise = (rs.getString("建议"));
				String Number = (rs.getString("电话号码"));
				adv = new Advise(id1, advise, Number, sf);
				advlist.add(adv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return advlist;

	}

public static List<Advise> Queryalladv_sf(String sf,String page_num) {// 查询所有相同身份建议
	Connection conn = DBUtil.getConnection();// 建立连接
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	List<Advise> advlist = null;
	int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
	int al_page=10;//每页10条数据
	try {
		stmt = conn.createStatement();
		String sql = "select * from advise where 匿名身份='" + sf + "'limit "+startpage+","+al_page+"";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		advlist = new ArrayList<Advise>();
		while (rs.next()) {
			Advise adv = null;
			int id1 = (rs.getInt("id"));
			String advise = (rs.getString("建议"));
			String Number = (rs.getString("电话号码"));
			adv = new Advise(id1, advise, Number, sf);
			advlist.add(adv);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return advlist;

}
public static int Queryalladv_sf_num(String sf) {// 查询所有相同身份建议 页数
	Connection conn = DBUtil.getConnection();// 建立连接
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	List<Advise> advlist = null;
	int count=0;
	try {
		stmt = conn.createStatement();
		String sql = "select count(*) as count from advise where 匿名身份='" + sf + "'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		advlist = new ArrayList<Advise>();
		if (rs.next()) {
			count=rs.getInt("count");
		}
		if (count % 10 == 0) {
			count /= 10;

		} else if (count % 10 != 0) {
			count = count / 10 + 1;
		}
		
		

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return count;

}

}
