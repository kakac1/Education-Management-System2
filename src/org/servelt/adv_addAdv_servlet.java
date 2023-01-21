package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.advDao;
import org.Dao.stuDao;
import org.Dao.teaDao;
import org.User.entity.Advise;
import org.User.entity.Student;
import org.User.entity.Teacher;

@WebServlet("/adv_addAdv_servlet")
public class adv_addAdv_servlet extends HttpServlet {// 增加建议

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String adv = request.getParameter("adv");
		String number = request.getParameter("number");
		String sf = request.getParameter("sf");
		Advise adv1 = new Advise(id, adv, number, sf);
		int count = 2;
		count = advDao.addAdv(adv1);
		request.setAttribute("count", count);
		if(sf.equals("学生")){
			Student stu = stuDao.Querystu(id);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("adv_page.jsp").forward(request, response);

		}
		if(sf.equals("老师")){
			Teacher tea = teaDao.Querytea(id);
			request.setAttribute("tea", tea);
			request.getRequestDispatcher("adv_page_tea.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
