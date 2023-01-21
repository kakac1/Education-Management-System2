package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.advDao;
import org.User.entity.Advise;

@WebServlet("/adv_updateadv_servlet")
public class adv_updateadv_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String adv = request.getParameter("adv");
		String number = request.getParameter("number");
		String sf = request.getParameter("sf");
		Advise adv1 = new Advise(id, adv, number, sf);
		boolean count = false;
		boolean count1 = advDao.existadv(id);
		if (count1) {
			count = advDao.updateadv(adv1);
		} else {
			System.out.println("该用户不存在！");
		}
		System.out.print(count);
		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
