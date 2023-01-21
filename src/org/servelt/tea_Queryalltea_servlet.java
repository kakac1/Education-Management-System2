package org.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.teaDao;
import org.User.entity.Teacher;

@WebServlet("/Queryalltea_servlet")
public class tea_Queryalltea_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nr=request.getParameter("query");
		String chooise=request.getParameter("chooise");
		String page_num=request.getParameter("page_num");
		ArrayList<Teacher> alltea =null;
		if(chooise.equals("all")){
			alltea = (ArrayList) teaDao.Queryalltea();
		}else if(chooise.equals("name")){
			alltea = (ArrayList)teaDao.Querytea_name(nr);			
		}else if(chooise.equals("sex")){
			if(nr.equals("男")){
				nr="m";	
			}else if(nr.equals("女")){
				nr="f";
			}
			alltea = (ArrayList)teaDao.Querytea_sex(nr);
			
		}
		System.out.print(alltea);
		request.setAttribute("userlist", alltea);
		request.setAttribute("nr", nr);
		request.setAttribute("chooise", chooise);
		request.getRequestDispatcher("teas.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
