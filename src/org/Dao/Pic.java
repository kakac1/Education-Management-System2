package org.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.User.entity.Manage;
import org.User.entity.Student;

public class Pic {
	public static int addpic(String xh, String name, String pic) {// 增加照片信息
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "insert into pic(id,学号,姓名,pic) values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, xh);
			pstmt.setString(2, name);
			pstmt.setString(3, pic);
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

	public static String Querypic(String xh) {// 查询管理员信息
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Manage manage = null;
		String pic = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from pic where 学号='" + xh + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {

				pic = (rs.getString("pic"));
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
		return pic;
	}

	
	public static boolean existmanage(String xh) {// 是否存在true/false
		return Querypic(xh) == null ? false : true;
	}
	public static int updatepic(String xh,String pic) {// 修改学生信息，id和学号不可以修改(1.增加成功，2.系统异常，4.电话号码不正确,5.密码格式不正确)
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int count1 = 6;
		

		try {
			stmt = conn.createStatement();

			String sql = "update pic set pic=? where 学号='" + xh + "'  ";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pic);
			
			
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
	
	
	
}
