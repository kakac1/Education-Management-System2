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

@WebServlet("/adv_Queryalladv_serlvet")
public class adv_Queryalladv_serlvet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nr=request.getParameter("query");
		String chooise=request.getParameter("chooise");
		String page_num = request.getParameter("page_num");
		int count = 0;
		ArrayList<Advise> alladv =null;
		if(chooise.equals("all")){
			count = advDao.Queryalladv_num();
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			alladv = (ArrayList) advDao.Queryalladv(page_num);
		}else if(chooise.equals("sf")){
			count = advDao.Queryalladv_sf_num(nr);
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			alladv = (ArrayList) advDao.Queryalladv_sf(nr,page_num);			
		} 
		System.out.println(nr+"66");
		request.setAttribute("userlist", alladv);
		request.setAttribute("nr", nr);
		request.setAttribute("page_num", page_num);
		request.setAttribute("count", count);
		request.setAttribute("chooise", chooise);
		request.getRequestDispatcher("advs.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
