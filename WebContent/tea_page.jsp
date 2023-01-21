<%@page import="org.User.entity.Teacher"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/stu_page.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师端</title>

</head>




<body>
	<%
			request.setCharacterEncoding("utf-8");
			Teacher tea = (Teacher) request.getAttribute("tea");
		%>
	<!--导航栏-->
	<div class="_nav">
		<!--logo-->
		<div class="logo">
			<img src="img/xianhezhuanglogo .png" />
		</div>
		<!--导航栏-->


	</div>

	<div id="apDiv13"></div>

	<div id="apDiv1"></div>
	<div id="apDiv15"></div>
	<div id="apDiv16"></div>
	<div id="apDiv2">
		<a href="" target="右frm">
			<div id="apDiv12">匿名发表建议</div>
		</a>
	</div>
	<div id="apDiva">教育信息管理系统</div>
	<a href="query_stu_page.jsp" target="右frm"><div id="apDiv21">查看学生信息</div></a>
	<iframe id="apDiv3" name="右frm"> </iframe>
	<div id="apDiv4"></div>
	<a href="tea_Querytea_servlet?id=<%=tea.getId()%>&operate=查询"
		target="右frm"><div id="apDiv17">查看个人信息</div></a>
	<a href=" tea_Querytea_servlet?id=<%=tea.getId()%>&operate=修改 "
		target="右frm"><div id="apDiv18">修改个人信息</div></a>
	<a href="tea_Querytea_servlet?operate=发表建议&id=<%=tea.getId()%>"
		target="右frm"><div id="apDiv19">匿名发表建议</div></a>
	<a href="index_page.jsp"><div id="apDiv8">退出登录</div></a>
	<a href="add_presonal_stu.jsp" target="右frm"><div id="apDiv16">添加学生信息</div></a>
	<div id="apDiv9"></div>

	<div id="apDiv11">
		你好： <a href="tea_Querytea_servlet?id=<%=tea.getId()%>&operate=查询"
			target="右frm"><%=tea.getName()%></a>
	</div>
	<!--二维码-->
	<div class="ewm">
		<div class="xx">
			信计一班<br /> 柯坤程1906210117<br />刘江1906210123<br />张超龙1906210138<br />许柏川1906210135<br />

			<br />
		</div>
	</div>
</body>
</html>