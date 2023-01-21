package org.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.User.entity.Teacher;

public class teaDao {
	public static int addtea(Teacher tea) {// 增加老师信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			System.out.println(conn.isClosed());
			stmt = conn.createStatement();
			String sql = "insert into teacher(id,编号,姓名,性别,出生日期,家庭住址,电话号码,密码,身份) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tea.getId());
			pstmt.setString(2, tea.getIden_id());
			pstmt.setString(3, tea.getName());
			pstmt.setString(4, tea.getSex());
			pstmt.setString(5, tea.getBirth());
			pstmt.setString(6, tea.getAddress());
			pstmt.setString(7, tea.getTelnumber());
			pstmt.setString(8, tea.getPwd());
			pstmt.setString(9, tea.getSf());
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

	public static boolean Deltea(int id) {// 删除老师信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "delete  from teacher where id='" + id + "'";
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

	public static int updatetea(Teacher tea) {// 修改老师信息，id和编号不可以修改1.增加成功，2.系统异常，3.学号格式不争取，4.电话号码不正确,5.密码格式不正确
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result=2;
		/*if(tea.getIden_id().length()!=10){
			result=3;
			return result;

		}*/
		if(tea.getPwd().length()>13||tea.getPwd().length()<10){
			result=5;
			return result;

		}
		if(tea.getTelnumber().length()!=11){
			result=4;
			return result;

		}
		try {
			stmt = conn.createStatement();
			String sql = "update teacher set 姓名=?,性别=?,出生日期=?,家庭住址=?,电话号码=?,密码=?where id='" + tea.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea.getName());
			pstmt.setString(2, tea.getSex());
			pstmt.setString(3, tea.getBirth());
			pstmt.setString(4, tea.getAddress());
			pstmt.setString(5, tea.getTelnumber());
			pstmt.setString(6, tea.getPwd());
			int count = pstmt.executeUpdate();// 执行后返回执行数据
			System.out.print(tea);
			if (count > 0) {
				result=1;
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result=2;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					result=2;
					e2.printStackTrace();
				}
			}
		}
		return result;
	}

	public static boolean existtea(int id) {// 是否存在true/false
		return Querytea(id) == null ? false : true;
	}
	public static boolean existtea(String iden_id) {// 是否存在true/false
		return Querytea_zh(iden_id) == null ? false : true;
	}

	public static Teacher Querytea(int id) {// 查询老师信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Teacher tea = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher where id='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, Sex, Birth, Address, Number, pwd, Sf);
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
		return tea;
	}
	public static Teacher Querytea_zh(String zh) {// 查询老师信息_账号
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Teacher tea = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher where 编号='" + zh + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, zh, name, Sex, Birth, Address, Number, pwd, Sf);
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
		return tea;
	}

	public static List<Teacher> Querytea_name(String name) {// 查询老师相同姓名信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Teacher> tealist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher where 姓名='" + name + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			tealist = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher tea = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, Sex, Birth, Address, Number, pwd, Sf);
				tealist.add(tea);
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
		return tealist;
	}

	public static List<Teacher> Querytea_name(String name,String page_num) {// 查询老师相同姓名信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Teacher> tealist = null;
		int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
		int al_page=10;//每页10条数据
		
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher where 姓名='" + name + "'limit '"+startpage+"','"+al_page+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			tealist = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher tea = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, Sex, Birth, Address, Number, pwd, Sf);
				tealist.add(tea);
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
		return tealist;
	}
	
	
	public static List<Teacher> Queryalltea() {// 查询所有老师的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Teacher> tealist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			tealist = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher tea = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, Sex, Birth, Address, Number, pwd, Sf);
				tealist.add(tea);
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
		return tealist;

	}
	public static List<Teacher> Queryalltea(String page_num) {// 查询所有老师的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Teacher> tealist = null;
		int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
		int al_page=10;//每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher limit '"+startpage+"','"+al_page+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			tealist = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher tea = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, Sex, Birth, Address, Number, pwd, Sf);
				tealist.add(tea);
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
		return tealist;

	}
	
	
	public static List<Teacher> Querytea_sex(String sex) {// 查询老师相同性别信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Teacher> tealist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from teacher where 性别='" + sex + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			tealist = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher tea = null;
				int id1 = (rs.getInt("id"));
				String iden_id = (rs.getString("编号"));
				String name = (rs.getString("姓名"));
				String Birth = (rs.getString("出生日期"));
				String Address = (rs.getString("家庭住址"));
				String Number = (rs.getString("电话号码"));
				String pwd = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				tea = new Teacher(id1, iden_id, name, sex, Birth, Address, Number, pwd, Sf);
				tealist.add(tea);
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
		return tealist;
	}


public static List<Teacher> Querytea_sex(String sex,String page_num) {// 查询老师相同性别信息
	Connection conn = DBUtil.getConnection();// 建立连接
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	List<Teacher> tealist = null;
	int startpage=(Integer.parseInt(page_num)-1)*10;//起始数据
	int al_page=10;//每页10条数据
	try {
		stmt = conn.createStatement();
		String sql = "select * from teacher where 性别='" + sex + "'limit '"+startpage+"','"+al_page+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		tealist = new ArrayList<Teacher>();
		while (rs.next()) {
			Teacher tea = null;
			int id1 = (rs.getInt("id"));
			String iden_id = (rs.getString("编号"));
			String name = (rs.getString("姓名"));
			String Birth = (rs.getString("出生日期"));
			String Address = (rs.getString("家庭住址"));
			String Number = (rs.getString("电话号码"));
			String pwd = (rs.getString("密码"));
			String Sf = (rs.getString("身份"));
			tea = new Teacher(id1, iden_id, name, sex, Birth, Address, Number, pwd, Sf);
			tealist.add(tea);
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
	return tealist;
}

}
