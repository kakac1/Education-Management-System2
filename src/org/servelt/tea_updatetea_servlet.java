package org.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.stuDao;
import org.Dao.teaDao;
import org.User.entity.Student;
import org.User.entity.Teacher;

@WebServlet("/tea_updatetea_servlet") // 修改老师信息(id和iden_不可修改)
public class tea_updatetea_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String operate = request.getParameter("operate");
		Teacher tea=null;
		Teacher tea2=null;
		boolean exist=false;
		int count = 2;
		if(operate.equals("查询信息")){
		String iden_id = request.getParameter("iden_id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String adress = request.getParameter("address");
		String number = request.getParameter("telnumber");
		String pwd = request.getParameter("pwd");
		String sf = request.getParameter("sf");
		 tea = new Teacher(id, iden_id, name, sex, birth, adress, number, pwd, sf);
		System.out.println(tea);
		exist = teaDao.existtea(id);
		if (exist) {
			count = teaDao.updatetea(tea);
		} else {
			count=3;
		}
		tea2=teaDao.Querytea(id);
		request.setAttribute("count", count);
		request.setAttribute("tea", tea2);
			request.getRequestDispatcher("update_tea_page.jsp").forward(request, response);
		}
		if(operate.equals("修改密码")){
			request.setCharacterEncoding("utf-8");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd1 = request.getParameter("newpwd1");
			String newpwd2 = request.getParameter("newpwd2");
         
			exist = stuDao.existstu(id);
			if (exist) {
				tea = teaDao.Querytea(id);
			} else {
				System.out.println("该用户不存在");
			}

			if (tea.getPwd().equals(oldpwd)) {// 6.原密码错误，7.新密码不一致
				if (newpwd1.equals(newpwd2)) {
					tea2 = new Teacher(tea.getId(),tea.getIden_id(),tea.getName(),tea.getSex(),tea.getBirth(),tea.getAddress(),tea.getTelnumber(),newpwd2,tea.getSf());
					count = teaDao.updatetea(tea2);
					request.setAttribute("count", count);
					request.setAttribute("tea", tea2);
					request.getRequestDispatcher("update_tea_page.jsp").forward(request, response);
				} else {
					count = 7;
				}
			} else {
				count = 6;
			}
		}
		
        
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
