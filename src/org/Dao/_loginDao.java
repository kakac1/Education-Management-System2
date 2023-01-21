package org.Dao;

import java.sql.*;

public class _loginDao {
	public static int login(int zh, String pwd, String id, String oldyzm, String newyzm) {
		int count = 0;// 1:登录成功，2：密码错误 3：该账号不存在 4:验证码错误 5:系统异常
		Connection conn = DBUtil.getConnection();// 建立连接
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String pass = null;
		try {
			stmt = conn.createStatement();
			String sql = "1";
			if (id.equals("学生")) {
				sql = "select * from stu where 学号='" + zh + "'  ";
			}
			if (id.equals("老师")) {
				sql = "select * from teacher where 编号='" + zh + "'  ";
			}
			if (id.equals("管理员")) {
				sql = "select * from admin where 编号='" + zh + "'  ";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				pass = rs.getString("密码");
					if (pass.equals(pwd)) {
						if (oldyzm.equals(newyzm)) {
							count = 1;
						} else {
							count = 4;
						}
					} else {
						count = 2;
					}
				

			} else {
				count = 3;
			}
		} catch (Exception e) {
			count = 5;
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					count = 5;
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