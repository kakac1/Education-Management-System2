package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.User.entity.Student;

@WebServlet("/delstu_servelt")
public class stu_delstu_servelt extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int count = 0;
		String page_num = request.getParameter("page_num");
		
		
		boolean a = false;
		if (stuDao.existstu(id)) {
			a = stuDao.Delstu(id);
		} else {
			System.out.println("该用户不存在");
		}
		String nr=request.getParameter("query");
		String chooise=request.getParameter("chooise");
		ArrayList<Student> allstu =null;
		if (chooise.equals("all")) {
			count = stuDao.Queryallstu_num();
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			allstu = (ArrayList) stuDao.Queryallstu(page_num);
			
		} else if (chooise.equals("bj")) {
			count = stuDao.Queryallbjstu_num(nr);
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			allstu = (ArrayList) stuDao.Queryallbjstu(nr, page_num);

		} else if (chooise.equals("name")) {
			count = stuDao.Queryallnamestu_num(nr);
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			allstu = (ArrayList) stuDao.Queryallnamestu(nr, page_num);

		} else if (chooise.equals("sex")) {
			
			if (nr.equals("男")) {
				nr = "m";
			} else if (nr.equals("女")) {
				nr = "f";
			}
			count = stuDao.Queryallsexstu_num(nr);
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			allstu = (ArrayList) stuDao.Queryallsexstu(nr, page_num);

		} else if (chooise.equals("tea")) {
			count = stuDao.Queryallteastu_num(nr);
			if (Integer.parseInt(page_num) > count) {
				page_num = "1";
			}
			allstu = (ArrayList) stuDao.Queryallteastu(nr, page_num);

		}

		request.setAttribute("userlist", allstu);
		request.setAttribute("count", count);
		request.setAttribute("nr", nr);
		request.setAttribute("chooise", chooise);
		request.setAttribute("page_num", page_num);
		request.getRequestDispatcher("stus.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
