package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.teaDao;

import org.User.entity.Teacher;

@WebServlet("/tea_Queryalltea_sex_servlet")
public class tea_Queryalltea_sex_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sex = request.getParameter("sex");
		ArrayList<Teacher> alltea = (ArrayList) teaDao.Querytea_sex(sex);
		System.out.print(alltea);

		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
