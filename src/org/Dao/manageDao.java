package org.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.User.entity.Manage;

public class manageDao {
	public static int addmanage(Manage manage) {// 增加管理员信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "insert into admin(id,编号,姓名,电话号码,密码,身份) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, manage.getId());
			pstmt.setString(2, manage.getIden_id());
			pstmt.setString(3, manage.getName());
			pstmt.setString(4, manage.getTelnumber());
			pstmt.setString(5, manage.getPwd());
			pstmt.setString(6, manage.getSf());
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

	public static boolean Delmanage(int id) {// 删除管理员信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "delete  from admin where id='" + id + "'";
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

	public static int updatemanage(Manage manage) {// 修改管理员信息，id和编号不可以修改
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		int count1=2;
		PreparedStatement pstmt = null;
		if(manage.getTelnumber().length()!=11){
			count1=4;
			return count1;

		}

		try {
			stmt = conn.createStatement();
			String sql = "update admin set 姓名=?,电话号码=?,密码=?where id='" + manage.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manage.getName());
			pstmt.setString(2, manage.getTelnumber());
			pstmt.setString(3, manage.getPwd());
			int count = pstmt.executeUpdate();// 执行后返回执行数据
			System.out.print(manage);
			if (count > 0) {
				count=1;
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					return 2;
				}
			}
		}
		return 1;
	}

	public static boolean existmanage(int id) {// 是否存在true/false
		return Querymanage(id) == null ? false : true;
	}
	public static boolean existmanage(String iden_id) {// 是否存在true/false
		return Querymanage(iden_id) == null ? false : true;
	}
	
	public static Manage Querymanage(int id) {// 查询管理员信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Manage manage = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from admin where id='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				manage = new Manage(id1, iden_id, name, Number, pwd, Sf);
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
		return manage;
	}
	public static Manage Querymanage(String zh) {// 查询管理员信息(按账号)
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Manage manage = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from admin where 编号='" +zh + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String name = (rs.getString("姓名"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				manage = new Manage(id1, zh, name, Number, pwd, Sf);
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
		return manage;
	}
	public static List<Manage> Queryallmanage() {// 查询所有管理员的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Manage> managelist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from admin ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			managelist = new ArrayList<Manage>();
			while (rs.next()) {
				Manage manage = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				manage = new Manage(id1, iden_id, name, Number, pwd, Sf);
				managelist.add(manage);
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
		return managelist;

	}


public static List<Manage> Queryallmanage(String page_num) {// 查询所有管理员的信息，按页码
	Connection conn = DBUtil.getConnection();// 建立连接
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	List<Manage> managelist = null;
	int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
	int al_page=10;//每页10条数据
	try {
		stmt = conn.createStatement();
		String sql = "select * from admin limit "+startpage+","+al_page+"";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		managelist = new ArrayList<Manage>();
		while (rs.next()) {
			Manage manage = null;
			int id1 = (rs.getInt("id"));
			String iden_id = (rs.getString("编号"));
			String name = (rs.getString("姓名"));
			String Number = (rs.getString("电话号码"));
			String pwd = (rs.getString("密码"));
			String Sf = (rs.getString("身份"));
			manage = new Manage(id1, iden_id, name, Number, pwd, Sf);
			managelist.add(manage);
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
	return managelist;

}

}
