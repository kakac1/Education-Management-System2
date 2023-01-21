package org.servelt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URLEncoder;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class get_pic_servlet
 */
@WebServlet("/get_pic_servlet")
public class get_pic_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * request.setCharacterEncoding("utf-8"); String
		 * filename=request.getParameter("filename");
		 * System.out.println(filename);
		 * 
		 * //设置响应头 response.setHeader("Content-Type",
		 * "application/octet-stream");//mime类型,二进制文件 //ie下载文件乱码问题
		 * response.addHeader("Content-Disposition",
		 * "inline;filename:"+URLEncoder.encode(filename,
		 * "utf-8"));//filename包含文件后缀：.txt .abc //获取需要下载的文件名
		 * //通过文件地址，将文件转为输入流，读到servlet InputStream in
		 * =getServletContext().getResourceAsStream("/upload/"+filename);
		 * //通过输入流 将刚才已经转为输入流的文件输出给用户 ServletOutputStream out
		 * =response.getOutputStream(); int len=-1; byte[] bs =new byte[1024];
		 * while((len=in.read(bs))>0){ out.write(bs,0,len);
		 * 
		 * } out.close(); in.close();
		 */
		 request.setCharacterEncoding("utf-8"); 
		 String fileName=request.getParameter("filename");
		// 1、文件存放路径
		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		int num = t.indexOf(".metadata");
		String path = t.substring(1, num).replace('/', '\\') + "jsp课设\\WebContent\\upload\\";
		System.out.println(path);
		// String path = "G:/java_web/jj/WebContent/upload/";
		// 2、需要下载的文件名
		
		File file = new File(path + fileName);
		response.reset();
		response.setCharacterEncoding("UTF-8");
		fileName = URLEncoder.encode(fileName, "UTF-8");
		// 设置响应头
		// ie下载文件乱码问题
		response.setHeader("Content-Disposition", "inline;fileName=" + URLEncoder.encode(fileName, "utf-8"));
		InputStream input = new FileInputStream(file);
		// 获取需要下载的文件名
		// 通过文件地址，将文件转为输入流，读到servlet
		ServletOutputStream out = response.getOutputStream();
		byte[] buff = new byte[1024];
		int len = -1;
		while ((len = input.read(buff)) != -1) {
			out.write(buff, 0, len);
			out.flush();
		}
		input.close();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
