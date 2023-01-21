package org.servelt;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activation.FileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.picDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class upload
 */
@WebServlet("/test")
public class text extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		boolean ismultipart=ServletFileUpload.isMultipartContent(request); 
		if(ismultipart){
			FileItemFactory factory = new DiskFileItemFactory();
			//创建一个解析器工厂
	 
	      //得到解析器，处理上传的文件数据，并将表单中每个输入项封装成一个FileItem 对象中
            ServletFileUpload upload = new ServletFileUpload(factory);
	     upload.setHeaderEncoding("utf-8");
			try {
				//存取表单所有信息
				List<FileItem> items=upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				//将前台的数据保存在items中
				int count=picDao.addpic(items);
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
