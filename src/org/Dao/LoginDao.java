package org.Dao;
// servlet中连接数据库获得结果集然后遍历结果集每次遍历的结果封装到实体类user中最后把每次得到的user中放入List<User>中，
//然后用request.setAttribute方法进行传递,用forword方法转发
// 在jsp页面中用request.getAttribute方法获取

import java.util.*;

import org.User.entity.Student;

import java.sql.*;
public class LoginDao {
    public List<Student> login(int zh,String pwd,String id,String oldyzm,String newyzm) {
    	    Connection conn = DBUtil.getConnection();//建立连接
			Statement stmt =null;
			ResultSet rs=null;
			PreparedStatement pstmt=null;
			List<Student> userlist= null;
			try{
			Class.forName("com.mysql.jdbc.Driver");	
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
			userlist= new ArrayList<Student>();
			Student user1=new Student();
            while(rs.next()){
                user1.setId(rs.getInt("学号"));
                user1.setUname(rs.getString("姓名"));
                user1.setPassword(rs.getString("密码"));
                userlist.add(user1);
            }
            }catch(Exception e){
				e.printStackTrace();
			}finally{
                if(conn !=null){
                    try {
                        conn.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if(rs !=null){
                    try {
                        rs.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if(rs !=null){
                    try {
                        rs.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }}
			
		return userlist;
    	}}

