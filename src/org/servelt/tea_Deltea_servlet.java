package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.teaDao;

@WebServlet("/Deltea_servlet")
public class tea_Deltea_servlet extends HttpServlet {// 根据id删除老师信息

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		boolean a = false;
		if (teaDao.existtea(id)) {
			a = teaDao.Deltea(id);
		} else {
			System.out.println("该用户不存在");
		}
		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
