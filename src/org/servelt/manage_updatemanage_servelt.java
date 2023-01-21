package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.manageDao;
import org.Dao.stuDao;
import org.User.entity.Manage;
import org.User.entity.Student;

@WebServlet("/manage_updatemanage_servelt")
public class manage_updatemanage_servelt extends HttpServlet {// 更新管理员信息

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String operate = request.getParameter("operate");
		boolean exist = false;
		Manage manage = null;
		Manage manage2 = null;
		int count = 2;
		if (operate.equals("修改个人信息")) {
			manage = manageDao.Querymanage(id);
			String number = request.getParameter("number");
			manage2 = new Manage(id, manage.getIden_id(), manage.getName(), number, manage.getPwd(), manage.getSf());
			exist = manageDao.existmanage(id);
			if (exist) {
				count = manageDao.updatemanage(manage2);
			} else {
				System.out.println("该用户不存在！");
			}
			request.setAttribute("count", count);
			request.setAttribute("manage", manage2);
			request.getRequestDispatcher("update_admin_page.jsp").forward(request, response);
		}

		System.out.println(operate);
		if (operate.equals("修改密码")) {
			request.setCharacterEncoding("utf-8");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd1 = request.getParameter("newpwd1");
			String newpwd2 = request.getParameter("newpwd2");
			exist = manageDao.existmanage(id);
			if (exist) {
				manage = manageDao.Querymanage(id);
				if (manage.getPwd().equals(oldpwd)) {// 6.原密码错误，7.新密码不一致
					if (newpwd1.equals(newpwd2)) {
						manage2 = new Manage(id, manage.getIden_id(), manage.getName(), manage.getTelnumber(), newpwd2,
								manage.getSf());
						count = manageDao.updatemanage(manage2);
						request.setAttribute("count", count);
						request.setAttribute("manage", manage2);
						request.getRequestDispatcher("update_admin_page_pwd.jsp").forward(request, response);
					} else {
						count = 7;
					}
				} else {
					count = 6;
				}
			} else {
				System.out.println("该用户不存在");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
