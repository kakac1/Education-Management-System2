package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.User.entity.Student;

@WebServlet("/Queryallstu_sex_servlet") // 查找相同性别
public class stu_Queryallstu_sex_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sex = request.getParameter("sex");
		ArrayList<Student> allstu = (ArrayList) stuDao.Queryallsexstu(sex);
		System.out.print(allstu);

		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
