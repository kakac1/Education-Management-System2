package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.manageDao;

@WebServlet("/manage_Delmanage_servelt")
public class manage_Delmanage_servelt extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		boolean a = false;
		if (manageDao.existmanage(id)) {
			a = manageDao.Delmanage(id);
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
