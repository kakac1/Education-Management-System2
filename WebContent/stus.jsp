<%@page import="org.Dao.stuDao"%>
<%@page import="org.User.entity.Student"%>
<%@page import="java.sql.*"%>

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生个人信息表</title>

</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		List<Student> userlist = (List<Student>) request.getAttribute("userlist");
		int count = Integer.parseInt(request.getAttribute("count").toString());
		String chooise = "";
		String nr = request.getAttribute("nr").toString();
		chooise = request.getAttribute("chooise").toString();
		String a = request.getAttribute("page_num").toString();
		if (Integer.parseInt(a) > count || !stuDao.isInteger(a)) {
			a = "1";
		}
		int page_num = Integer.parseInt(a);

		if (page_num > count) {
			page_num = 1;
		}
	%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>号数</th>
			<th>家庭地址</th>
			<th>学分</th>
			<th>电话号码</th>
			<th>老师</th>
			<th>班级</th>
		</tr>
		<%
			for (Student stu : userlist) {
		%>
		<tr>
			<td><a
				href="stu_Querystu_servlet?id=<%=stu.getId()%>&operate=老师查询学生&nr=<%=nr%>&chooise=<%=chooise%>&page_num=<%=page_num%>"
				target="frm"><%=stu.getxh()%></a></td>
			<td><%=stu.getUname()%></td>
			<td>
				<%
					if (stu.getSex().equals("m")) {
				%> <%='男'%> <%
 	} else if (stu.getSex().equals("f")) {
 %> <%='女'%> <%
 	}
 %>
			</td>
			<td><%=stu.getBirth()%></td>
			<td><%=stu.getNum()%></td>
			<td><%=stu.getAddress()%></td>
			<td><%=stu.getCredit()%></td>
			<td><%=stu.getNumber()%></td>
			<td><%=stu.gettea()%></td>
			<td><%=stu.getbj()%></td>
			<td><a
				href="delstu_servelt?id=<%=stu.getId()%>&page_num=<%=page_num%>&query=<%=nr%>&chooise=<%=chooise%>   ">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	共<%=count%>页
	<%
		if (page_num == 1 && page_num < count) {
	%>
	<a
		href="Queryallstu_tea_servlet?chooise=<%=chooise%>&page_num=<%=page_num + 1%>&query=<%=nr%> ">
		下一页</a>
	<%
		} else if (page_num == count && page_num != 1) {
	%>
	<a
		href="Queryallstu_tea_servlet?chooise=<%=chooise%>&page_num=<%=page_num - 1%>&query=<%=nr%> ">
		上一页</a>
	<%
		} else if (page_num < count) {
	%>
	<a
		href="Queryallstu_tea_servlet?chooise=<%=chooise%>&page_num=<%=page_num - 1%>&query=<%=nr%> ">
		上一页</a>
	<a
		href="Queryallstu_tea_servlet?chooise=<%=chooise%>&page_num=<%=page_num + 1%>&query=<%=nr%> ">
		下一页</a>
	<%
		}
		if (page_num == 1 && userlist.size() < 10) {
		}

		if (userlist.size() == 10) {
	%>
	<form name="form1" method="post"
		action="Queryallstu_tea_servlet?chooise=<%=chooise%>&query=<%=nr%> ">
		<input type="text" name="page_num"
			oninput="value=value.replace(/[^\d]/g,'')"
			placeholder="第<%=page_num%>页,请输入转页数" height="30px" /> <input
			type="submit" value="跳转">
	</form>
	<%
		}
	%>
</body>
</html>