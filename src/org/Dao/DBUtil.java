package org.Dao;

import java.util.*;
import java.sql.*;

public class DBUtil {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/jsp_item?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "2858";
	private static Connection conn = null;

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("数据库初始化成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库初始化失败");
		}
		return conn;

	}

}
