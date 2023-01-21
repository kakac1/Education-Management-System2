package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.advDao;
import org.User.entity.Advise;

@WebServlet("/adv_Queryadv_servlet")
public class adv_Queryadv_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Advise manage = null;
		boolean count1 = advDao.existadv(id);
		if (count1) {
			manage = advDao.Queryadv(id);
		} else {
			System.out.println("该用户不存在");
		}
		System.out.println(manage);

		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
