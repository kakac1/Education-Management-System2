package org.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.User.entity.Student;

public class stuDao {
	public static int addstu(Student stu) {// 增加学生信息(1.增加成功，2.系统异常，3.学号格式不争取，4.电话号码不正确,5.密码格式不正确)
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		int count1 = 2;
		if (stu.getxh().length() != 10) {
			count1 = 3;
			return count1;

		}
		if (stu.getPassword().length() <= 13 && stu.getPassword().length() >= 10) {
			count1 = 5;
			return count1;

		}
		if (stu.getNumber().length() != 11) {
			count1 = 4;
			return count1;

		}
		try {
			
			stmt = conn.createStatement();
			String sql = "insert into stu(id,学号,姓名,性别,出生日期,号数,班级,家庭住址,学分,电话号码,密码,身份,老师) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getId());
			pstmt.setString(2, stu.getxh());
			pstmt.setString(3, stu.getUname());
			pstmt.setString(4, stu.getSex());
			pstmt.setString(5, stu.getBirth());
			pstmt.setInt(6, stu.getNum());
			pstmt.setString(7, stu.getbj());
			pstmt.setString(8, stu.getAddress());
			pstmt.setInt(9, stu.getCredit());
			pstmt.setString(10, stu.getNumber());
			pstmt.setString(11, stu.getPassword());
			pstmt.setString(12, stu.getSf());
			pstmt.setString(13, stu.gettea());
			int count = pstmt.executeUpdate();// 执行后返回执行数据
			if (count > 0) {
				count1 = 1;
				return count1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			count1 = 2;
			return count1;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					count1 = 2;
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
		return count1;
	}

	public static boolean Delstu(int id) {// 删除学生信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "delete  from stu where id='" + id + "'";
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

	public static int updatestu(Student stu) {// 修改学生信息，id和学号不可以修改(1.增加成功，2.系统异常，4.电话号码不正确,5.密码格式不正确)
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int count1 = 2;
		if (stu.getPassword().length() > 13 || stu.getPassword().length() < 10) {
			count1 = 5;
			return count1;
		}
		if (stu.getNumber().length() != 11) {
			count1 = 4;
			return count1;
		}

		try {
			stmt = conn.createStatement();

			String sql = "update stu set 姓名=?,性别=?,出生日期=?,号数=?,班级=?,家庭住址=?,学分=?,电话号码=?,密码=?,老师=?where id='"
					+ stu.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getUname());
			pstmt.setString(2, stu.getSex());
			pstmt.setString(3, stu.getBirth());
			pstmt.setInt(4, stu.getNum());
			pstmt.setString(5, stu.getbj());
			pstmt.setString(6, stu.getAddress());
			pstmt.setInt(7, stu.getCredit());
			pstmt.setString(8, stu.getNumber());
			pstmt.setString(9, stu.getPassword());
			pstmt.setString(10, stu.gettea());
			int count = pstmt.executeUpdate();// 执行后返回执行数据
			System.out.print(stu);
			if (count > 0) {
				count1 = 1;
				return count1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			count1 = 2;
			return count1;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					count1 = 2;
					return count1;
				}
			}
		}
		return count1;
	}

	public static boolean existstu(int id) {// 是否存在true/false
		return Querystu(id) == null ? false : true;
	}

	public static boolean existstu_xh(String xh) {// 是否存在true/false
		return Querystu_zh(Integer.parseInt(xh)) == null ? false : true;
	}

	public static Student Querystu(int id) {// 查询学生信息,根据id
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Student stu = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where id='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			System.out.print(111);

			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String xh = (rs.getString("学号"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				int Num = (rs.getInt("号数"));
				String bj = (rs.getString("班级"));
				String Address = (rs.getString("家庭住址"));
				int Credit = (rs.getInt("学分"));
				String Number = (rs.getString("电话号码"));
				String Password = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				String tea = (rs.getString("老师"));
				stu = new Student(id1, xh, name, Password, Sex, Birth, Num, bj, Address, Credit, Sf, Number, tea);
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
		return stu;

	}

	public static Student Querystu_zh(int zh) {// 查询学生信息,根据账号
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Student stu = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 学号='" + zh + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int id1 = (rs.getInt("id"));
				String xh = (rs.getString("学号"));
				String name = (rs.getString("姓名"));
				String Sex = (rs.getString("性别"));
				String Birth = (rs.getString("出生日期"));
				int Num = (rs.getInt("号数"));
				String bj = (rs.getString("班级"));
				String Address = (rs.getString("家庭住址"));
				int Credit = (rs.getInt("学分"));
				String Number = (rs.getString("电话号码"));
				String Password = (rs.getString("密码"));
				String Sf = (rs.getString("身份"));
				String tea = (rs.getString("老师"));
				stu = new Student(id1, xh, name, Password, Sex, Birth, Num, bj, Address, Credit, Sf, Number, tea);
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
		return stu;

	}

	public static List<Student> Queryallstu(String page_num) {// 查询所有学生的信息，分页查询
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int startpage = (Integer.parseInt(page_num) - 1) * 10;// 起始数据
		String al_page = "10";// 每页10条数据

		String a = String.valueOf(startpage);

		try {
			stmt = conn.createStatement();
			String sql = "select * from stu limit " + a + "," + al_page + " ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static int Queryallstu_num() {// 查询所有学生的信息页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) as count from stu ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
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

	public static List<Student> Queryallstu() {// 查询所有学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static List<Student> Queryallnamestu(String name, String page_num) {// 查询所有相同名字学生的信息,分页查询
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int startpage = (Integer.parseInt(page_num) - 1) * 10;// 起始数据
		int al_page = 10;// 每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 姓名 like '%" + name + "%' limit " + startpage + "," + al_page + "  ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static int Queryallnamestu_num(String name) {// 查询所有相同名字学生的信息页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int count = 0;
		try {
			stmt = conn.createStatement();
			String sql = "select countt(*) as count from stu where 姓名 like '" + name + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				count = rs.getInt("count");
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

	public static List<Student> Queryallnamestu(String name) {// 查询所有相同名字学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
        
        System.out.println(name);
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 姓名 like  '" + name + "'  ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static List<Student> Queryallbjstu(String bj, String page_num) {// 查询所有相同班级学生的信息，分页查询
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int startpage = (Integer.parseInt(page_num) - 1) * 10;// 起始数据
		int al_page = 10;// 每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 班级 like '" + bj + "' limit " + startpage + "," + al_page + "";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static int Queryallbjstu_num(String bj) {// 查询所有相同班级学生的 信息页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int count = 0;
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) as count from stu where 班级 like '" + bj + "' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				count = rs.getInt("count");
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

	public static List<Student> Queryallbjstu(String bj) {// 查询所有相同班级学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 班级 like '" + bj + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static List<Student> Queryallsexstu(String sex) {// 查询所有相同性别学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 性别 like '" + sex + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static int Queryallsexstu_num(String sex) {// 查询所有相同性别学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int count = 0;
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) as count from stu where 性别 like '" + sex + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				count = rs.getInt("count");
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

	public static List<Student> Queryallsexstu(String sex, String page_num) {// 查询所有相同性别学生的信息,分页查询
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int startpage = (Integer.parseInt(page_num) - 1) * 10;// 起始数据
		int al_page = 10;// 每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 性别 like '" + sex + "'limit " + startpage + "," + al_page + "";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}

	public static List<Student> Queryallteastu(String tea) {// 查询所有相同老师学生的信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 老师 like '" + tea + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}
	
	public static int Queryallteastu_num(String tea) {// 查询所有相同老师学生的信息页数
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int count=0;
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) as count from stu where 老师 like '" + tea + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
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

	public static List<Student> Queryallteastu(String tea, String page_num) {// 查询所有相同老师学生的信息，分页查询
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Student> userlist = null;
		int startpage = (Integer.parseInt(page_num) - 1) * 10;// 起始数据
		int al_page = 10;// 每页10条数据
		try {
			stmt = conn.createStatement();
			String sql = "select * from stu where 老师 like '" + tea + "'limit " + startpage + "," + al_page + "";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			userlist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setxh(rs.getString("学号"));
				stu.setUname(rs.getString("姓名"));
				stu.setSex(rs.getString("性别"));
				stu.setBirth(rs.getString("出生日期"));
				stu.setNum(rs.getInt("号数"));
				stu.setClass(rs.getString("班级"));
				stu.setAddress(rs.getString("家庭住址"));
				stu.setCredit(rs.getInt("学分"));
				stu.setNumber(rs.getString("电话号码"));
				stu.setPassword(rs.getString("密码"));
				stu.setSf(rs.getString("身份"));
				stu.settea(rs.getString("老师"));
				userlist.add(stu);
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
		return userlist;

	}
	public static boolean isInteger(String str) {//判断是否全为数字 
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
        return pattern.matcher(str).matches(); 
}
}
