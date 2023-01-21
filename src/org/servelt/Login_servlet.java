package org.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao._loginDao;
import org.Dao.manageDao;
import org.Dao.stuDao;
import org.Dao.teaDao;
import org.User.entity.Manage;
import org.User.entity.Student;
import org.User.entity.Teacher;

@WebServlet("/Login_servlet") // 登录
public class Login_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int zh = Integer.parseInt(request.getParameter("zh"));
		String pass = request.getParameter("pwd");
		String id = request.getParameter("id");
		String newyzm = request.getParameter("newyzm");
		String oldyzm = (String) request.getSession().getAttribute("numrand");
		int count = _loginDao.login(zh, pass, id, oldyzm, newyzm);
		if (count == 1) {
			if (id.equals("学生")) {
				Student student=stuDao.Querystu_zh(zh);
				request.setAttribute("student", student);
				request.getRequestDispatcher("stu_page.jsp").forward(request, response); // 转发到学生端页面
			} else if (id.equals("老师")) {
				Teacher tea=teaDao.Querytea_zh(String.valueOf(zh));
				request.setAttribute("tea",tea);
				System.out.println(tea);
				request.getRequestDispatcher("tea_page.jsp").forward(request, response); // 转发到教师端页面
			} else {
				Manage admin=manageDao.Querymanage(String.valueOf(zh));
				request.setAttribute("manage",admin);
				System.out.println(admin);
				request.getRequestDispatcher("back_page.jsp").forward(request, response);// 跳转到后台端页面
			}
		}
		if (count != 1) {
			request.setAttribute("count", count);
			request.getRequestDispatcher("index_page.jsp").forward(request, response); // 登录失败，跳转到登录首页
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
