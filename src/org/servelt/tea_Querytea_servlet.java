package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.teaDao;

import org.User.entity.Teacher;

@WebServlet("/tea_Querytea_servlet")
public class tea_Querytea_servlet extends HttpServlet {// 查询老师信息1.查询成功，2，该用户不存在，3，系统错误
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String operate = request.getParameter("operate");
		Teacher tea = null;
		int result = 3;
		boolean count1 = teaDao.existtea(id);
		if (count1) {
			tea = teaDao.Querytea(id);
		} else {
			result = 2;
		}
		request.setAttribute("tea", tea);
		if(operate.equals("查询")){
			request.getRequestDispatcher("personal_tea.jsp").forward(request, response);
		}
		if(operate.equals("修改")){
			request.getRequestDispatcher("update_tea_page.jsp").forward(request, response);
		}
		if(operate.equals("修改密码")){
			
			request.getRequestDispatcher("update_tea_page_pwd.jsp").forward(request, response);
		}
		if(operate.equals("发表建议")){
			request.getRequestDispatcher("adv_page_tea.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
