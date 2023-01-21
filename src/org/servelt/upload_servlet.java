package org.servelt;

import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Dao.Pic;
import org.Dao.picDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload_servlet")
public class upload_servlet extends HttpServlet {// 将文件上传到upload下
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String xh = request.getParameter("xh");
		String name = request.getParameter("name");
		System.out.println(xh + name);
		String itemname = "";
		String filename = "";
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if (ismultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建一个解析器工厂

			// 得到解析器，处理上传的文件数据，并将表单中每个输入项封装成一个FileItem 对象中
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// 存取表单所有信息
				List<FileItem> items = upload.parseRequest(request);// 前端的数据就在item中
				Iterator<FileItem> iter = items.iterator();// 迭代器遍历

				while (iter.hasNext()) {// 遍历表中的数据
					FileItem item = iter.next();
					// 判断前端字段是普通字段还是文件字段
					itemname = item.getFieldName();
					if (item.isFormField()) {
						/*
						 * if (itemname.equals("xh")) {// 根据name属性，判断所要的字段 xh =
						 * item.getString("utf-8");// 取值 } else if
						 * (itemname.equals("name")) { name =
						 * item.getString("utf-8");// 取值 } else {
						 * System.out.println("其他字段"); }
						 */
					} else {
						filename = item.getName();// 获取文件名
						System.out.println("后台输出：" + item.getName());// 打印出文件名
						// 上传的文件名
						// 获取文件内容
						// 定义文件路径
						// 获取服务器路径G:\\java作业\\jj\\WebContent\\upload
						String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
						int num = t.indexOf(".metadata");
						String path = t.substring(1, num).replace('/', '\\') + "jsp课设\\WebContent\\upload";
						System.out.println(filename);
						/*
						 * String newname =
						 * filename.substring(filename.lastIndexOf(".") + 1);
						 * newname = sno + "." + newname;
						 */

						if (Pic.existmanage(xh)) {
							Pic.updatepic(xh, filename);

						} else {
							Pic.addpic(xh, name, filename);

						}
						System.out.println(xh + name);
						File file = new File(path, filename);
						item.write(file);// 上传
						System.out.println(filename + "上传成功");
						request.getRequestDispatcher("update_stu_page.jsp").forward(request, response);
						return;
					}
					// 将前台的数据保存在items中
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}