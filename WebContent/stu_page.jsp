<%@page import="org.User.entity.Student"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/stu_page.css" rel="stylesheet" type="text/css" />
<title>学生端</title>

</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		String id = String.valueOf(request.getAttribute("id"));
		Student stu = (Student) request.getAttribute("student");
	%>
	<div id="apDiv1"></div>
	<div id="apDiv2"></div>
	<div id="apDiv13">
		<div id="apDiv11">
			<font color="black">你好：<a
				href="stu_Querystu_servlet?id=<%=stu.getId()%>&operate=查询"
				target="右frm"> <%
				out.print(stu.getUname());
			%>
			</a></font>

		</div>
	</div>
	<div id="apDiv14"></div>
	<div id="apDiv15"></div>
	<div id="apDiva">教育信息管理系统</div>
	<iframe id="apDiv3" name="右frm"> </iframe>

	<div id="apDiv4"></div>
	<a href="stu_Querystu_servlet?id=<%=stu.getId()%>&operate=查询"
		target="右frm"><div id="apDiv5">查看个人信息</div></a>
	<a href="stu_Querystu_servlet?operate=更新&id=<%=stu.getId()%>"
		target="右frm"><div id="apDiv6">修改个人信息</div></a>
	<a href="stu_Querystu_servlet?operate=发表建议&id=<%=stu.getId()%>"
		target="右frm"><div id="apDiv7">匿名发表建议</div></a>

	<a href="index_page.jsp"><div id="apDiv8">退出登录</div></a>
	<div id="apDiv9"></div>


	<!--二维码-->
	<div class="ewm">
		<div class="xx">
			信计一班<br /> 柯坤程1906210117<br />刘江1906210123<br />张超龙1906210138<br />许柏川1906210135<br />

			<br />
		</div>
	</div>
</body>
</html>