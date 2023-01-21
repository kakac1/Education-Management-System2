package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.advDao;
import org.User.entity.Advise;

@WebServlet("/adv_Queryalladv_sf_servlet")
public class adv_Queryalladv_sf_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sf = request.getParameter("sf");
		ArrayList<Advise> alladv = (ArrayList) advDao.Queryalladv_sf(sf);
		System.out.print(alladv);
		request.getRequestDispatcher("stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
