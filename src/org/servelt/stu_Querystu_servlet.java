package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.User.entity.Student;

@WebServlet("/stu_Querystu_servlet") // 查询单个学生信息
public class stu_Querystu_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String operate=request.getParameter("operate");

		int id = Integer.parseInt(request.getParameter("id"));
		Student stu = null;
		boolean count1 = stuDao.existstu(id);
		if (count1) {
			stu = stuDao.Querystu(id);
		} else {
			System.out.println("该用户不存在");
		}
        request.setAttribute("student", stu);
        if(operate.equals("查询")){
        	request.getRequestDispatcher("presonal_stu.jsp").forward(request, response);
        	
        }else if(operate.equals("更新")){
        	request.getRequestDispatcher("update_stu_page.jsp").forward(request, response);
        	
        }else if(operate.equals("修改密码")){
        	request.getRequestDispatcher("update_stu_page_pwd.jsp").forward(request, response);
        	
        }else if(operate.equals("发表建议")){
        	request.getRequestDispatcher("adv_page.jsp").forward(request, response);
        	
        }else if(operate.equals("老师查询学生")){
        	String nr=request.getParameter("query");
    		String chooise=request.getParameter("chooise");
    		String page_num = request.getParameter("page_num");
    		request.setAttribute("nr", nr);
    		request.setAttribute("chooise", chooise);
    		request.setAttribute("page_num", page_num);
        	request.getRequestDispatcher("presonal_tea_stu.jsp").forward(request, response);
        	
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
