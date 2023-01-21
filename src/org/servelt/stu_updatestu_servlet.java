package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.User.entity.Student;

@WebServlet("/updatestu") // 更新学生信息
public class stu_updatestu_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String operate = request.getParameter("operate");
		int count = 2;
		boolean exist = false;
		Student stu = null;
		Student stu2 = null;
		if (operate.equals("修改信息")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String xh = request.getParameter("xh");
			String name = request.getParameter("Uname");
			String sex = request.getParameter("sex");
			String birth = request.getParameter("birth");
			int num = Integer.parseInt(request.getParameter("num"));
			String class1 = request.getParameter("bj");
			String adress = request.getParameter("address");
			int credit = Integer.parseInt(request.getParameter("credit"));
			String number = request.getParameter("number");
			String pwd = request.getParameter("password");
			String sf = request.getParameter("sf");
			String tea = request.getParameter("tea");
			stu = new Student(id, xh, name, pwd, sex, birth, num, class1, adress, credit, sf, number, tea);
			exist = stuDao.existstu(id);// 查询是否存在
			if (exist) {
				count = stuDao.updatestu(stu);
				System.out.println(count);
				request.setAttribute("count", count);
				request.setAttribute("student", stu);
				request.getRequestDispatcher("update_stu_page.jsp").forward(request, response);
			}
		}
		if (operate.equals("修改密码")) {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String oldpwd = request.getParameter("oldpwd");
			String newpwd1 = request.getParameter("newpwd1");
			String newpwd2 = request.getParameter("newpwd2");
         
			exist = stuDao.existstu(id);
			if (exist) {
				stu = stuDao.Querystu(id);
			} else {
				System.out.println("该用户不存在");
			}

			if (stu.getPassword().equals(oldpwd)) {// 6.原密码错误，7.新密码不一致
				if (newpwd1.equals(newpwd2)) {
					stu2 = new Student(id, stu.getxh(), stu.getUname(), newpwd2, stu.getSex(), stu.getBirth(),
							stu.getNum(), stu.getbj(), stu.getAddress(), stu.getCredit(), stu.getSf(), stu.getNumber(),
							stu.gettea());
					count = stuDao.updatestu(stu2);
					request.setAttribute("count", count);
					request.setAttribute("student", stu);
					request.getRequestDispatcher("update_stu_page.jsp").forward(request, response);
				} else {
					count = 7;
				}
			} else {
				count = 6;
			}
			request.setAttribute("count", count);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("update_stu_page_pwd.jsp").forward(request, response);

		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
