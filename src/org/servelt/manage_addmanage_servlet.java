package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.manageDao;
import org.User.entity.Manage;


@WebServlet("/manage_addmanage_servlet")
public class manage_addmanage_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String iden_id = request.getParameter("iden_id");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String pwd = request.getParameter("pwd");
		String sf = request.getParameter("sf");
		Manage manage = new Manage(id, iden_id,name,number,pwd,sf);
		System.out.println(manage);
		int count = 2;
		boolean count1 = manageDao.existmanage(iden_id);
		if (!count1) {
			System.out.println("该用户不存在可以增！");
			count = manageDao.addmanage(manage);
		}else{
			count=3;
		}
		
		
		request.setAttribute("count", count);
		request.getRequestDispatcher("add_presonal_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
