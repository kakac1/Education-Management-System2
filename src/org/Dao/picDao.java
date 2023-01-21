package org.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import java.util.Iterator;
import java.util.List;


import org.User.entity.Student;

import org.apache.commons.fileupload.FileItem;



public class picDao {
	public static int addpic(List<FileItem> items) {
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		InputStream file = null;
		byte[] buffer = null;
		String sql = null;
		int count1 = 0;
		int count = 0;
		String filename = "";
		Iterator<FileItem> iter = items.iterator();
		String sno = "0";
		String name = "";
		FileItem item=null;
		try {
			while (iter.hasNext()) {// 遍历表中的数据
				
				 item = iter.next();
				// 判断前端字段是普通字段还是文件字段
				
				if (item.isFormField()) {
					if (item.getFieldName().equals("sno")) {// 根据name属性，判断所要的字段
						sno = item.getString("utf-8");
                    System.out.println(sno);
					} 
					if (item.getFieldName().equals("name")) {
						name = item.getString("utf-8");
                      System.out.println(name);
                      
					} else {
						System.out.println("其他字段");
					}

				} else {
					filename = item.getName();// 获取文件名
					// 获取文件内容
					file = item.getInputStream();// 将文件转为输入流
					buffer = new byte[file.available()];// 将字节数组直接存进去数据库就可以
				}
				stmt = conn.createStatement();
				sql = "insert into picture (id,sno,name,picture) values(null,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sno);// 将第一个占位符（?）设值
				pstmt.setString(2, name);// 将第2个占位符（?）设值
				pstmt.setBytes(3, buffer);// 将第3个占位符设值
				count = pstmt.executeUpdate();// 执行语句

			
		}} catch (Exception e) {
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

		return 1;
	}
	public static int getpic(String sno) {//查找图片
		Connection conn = DBUtil.getConnection();// 建立连接
		PreparedStatement pstmt = null;
		Statement stmt = null;
		InputStream file = null;
		byte[] buffer = null;
		String sql = null;
		int count1 = 0;
		int count = 0;
		ResultSet rs=null;
		try {
				stmt = conn.createStatement();
				sql = "select * picture where sno='"+sno+"'";
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();//执行查询
				if(rs.next()){//循环取出所有图片
					byte[] buff =rs.getBytes("picture");//图片所在的字段名，前面存的是byte 现在相对应的取
					//OutputStream os = request.getOutputStream();//获得输出流
					//os.write(buff);//将其输出页面
					System.out.println("取出成功");
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

		return 1;
	}
}
