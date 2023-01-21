package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.User.entity.Student;

@WebServlet("/stu_addstu_servlet")
public class stu_addstu_servlet extends HttpServlet {// 增加学生信息

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String xh = request.getParameter("xh");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		int num = Integer.parseInt(request.getParameter("num"));
		String class1 = request.getParameter("bj");
		String adress = request.getParameter("address");
		int credit = Integer.parseInt(request.getParameter("credit"));
		String number = request.getParameter("number");
		String pwd = request.getParameter("pwd");
		String sf = request.getParameter("sf");
		String tea = request.getParameter("tea");
		if(sex.equals("男")){
		    sex="m";
		}else{
			sex="f";
		}
		int id=0;
		Student stu = new Student(id,xh, name, pwd, sex, birth, num, class1, adress, credit, sf, number, tea);
		int result = 2;//(1.增加成功，2.系统异常，3.学号格式不争取，4.电话号码不正确,5.密码格式不正确)
		boolean exist = stuDao.existstu_xh(xh);
		if (!exist) {

			result = stuDao.addstu(stu);
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("add_presonal_stu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
