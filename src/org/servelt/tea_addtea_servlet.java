package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.teaDao;

import org.User.entity.Teacher;

@WebServlet("/tea_addtea_servlet")
public class tea_addtea_servlet extends HttpServlet {// 增加老师信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String iden_id = request.getParameter("iden_id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String adress = request.getParameter("address");
		String number = request.getParameter("number");
		String pwd = request.getParameter("pwd");
		String sf = request.getParameter("sf");
		if(sex.equals("男")){
		    sex="m";
		}else{
			sex="f";
		}
		Teacher tea = new Teacher(id, iden_id, name, sex, birth, adress, number, pwd, sf);
		System.out.println(tea);
		int count = 2;
		boolean count1 = teaDao.existtea(iden_id);
		if (!count1) {
			count = teaDao.addtea(tea);
		}else{
			count=3;
		}
		System.out.print(count);
		request.setAttribute("result", count);
		request.getRequestDispatcher("add_presonal_tea.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
