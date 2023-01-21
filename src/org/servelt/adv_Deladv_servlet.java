package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.advDao;
import org.Dao.stuDao;
import org.User.entity.Advise;
import org.User.entity.Student;

@WebServlet("/adv_Deladv_servlet")
public class adv_Deladv_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String page_num = request.getParameter("page_num");
		int count = 0;
		boolean a = false;
		if (advDao.existadv(id)) {
			a = advDao.Deladv(id);
		} else {
			System.out.println("该用户不存在");
		}
		String nr=request.getParameter("query");
		String chooise=request.getParameter("chooise");
		ArrayList<Advise> alladv =null;
		if(chooise.equals("all")){
			count = advDao.Queryalladv_num();
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			alladv = (ArrayList) advDao.Queryalladv(page_num);
		}else if(chooise.equals("sf")){
			alladv = (ArrayList) advDao.Queryalladv_sf(nr);			
		} 
		System.out.print(alladv);
		request.setAttribute("userlist", alladv);
		request.setAttribute("nr", nr);
		request.setAttribute("chooise", chooise);
		request.setAttribute("page_num", page_num);
		request.setAttribute("count", count);
		request.getRequestDispatcher("advs.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
