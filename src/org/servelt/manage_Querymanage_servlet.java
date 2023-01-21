package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.manageDao;

import org.User.entity.Manage;

@WebServlet("/manage_Querymanage_servlet")
public class manage_Querymanage_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String operate = request.getParameter("operate");
		Manage manage = null;
		boolean count1 = manageDao.existmanage(id);
		if (count1) {
			manage = manageDao.Querymanage(id);
		} else {
			System.out.println("该用户不存在");
		}
		request.setAttribute("manage", manage);
		if (operate.equals("查询")) {
			request.getRequestDispatcher("presonal_admin.jsp").forward(request, response);
		}
		if (operate.equals("修改密码")) {
			request.getRequestDispatcher("update_admin_page_pwd.jsp").forward(request, response);
		}if (operate.equals("修改个人信息")) {
			request.getRequestDispatcher("update_admin_page.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
