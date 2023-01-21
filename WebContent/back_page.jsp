
<%@page import="org.User.entity.Manage"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台端</title>
<link href="./css/back_page.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<%
		request.setCharacterEncoding("utf-8");
		Manage manage = (Manage) request.getAttribute("manage");
	%>
	<a href="add_presonal_tea.jsp" target="右frm"><div id="apDiv13">添加教师信息</div></a>
	<a href="add_presonal_admin.jsp" target="右frm">
		<div id="apDiv14">添加管理员信息</div>
	</a>
	<div id="apDiva">教育信息管理系统</div>
	<a href="query_tea_page.jsp" target="右frm"><div id="apDiv15">管理教师信息</div></a>
	<div id="apDiv1"></div>
	<div id="apDiv2"></div>
	<div id="apDiv16">
		<div id="apDiv11">
			你好： <a
				href="manage_Querymanage_servlet?id=<%=manage.getId()%>&operate=查询"
				target="右frm"> <%=manage.getName()%>
		</div>
	</div>
	<div id="apDiv17"></div>
	
	<iframe id="apDiv3" name="右frm"> </iframe>
	
	<div id="apDiv4"></div>
	<a href="manage_Querymanage_servlet?id=<%=manage.getId()%>&operate=查询"
		target="右frm"><div id="apDiv5">查看个人信息</div></a>
	<a
		href="manage_Querymanage_servlet?id=<%=manage.getId()%>&operate=修改个人信息"
		target="右frm"><div id="apDiv6">修改个人信息</div></a>
	<a href="query_adv_page.jsp" target="右frm"><div id="apDiv7">
			查看匿名建议</div></a>
	<a href="index_page.jsp"><div id="apDiv8">退出登录</div></a>
	<div id="apDiv9"></div>
	</div>
	<!--二维码-->
	<div class="ewm">
		<div class="xx">
			信计一班<br /> 柯坤程1906210117<br />刘江1906210123<br />张超龙1906210138<br />许柏川1906210135<br />

			<br />
		</div>
	</div>
	<!--导航栏-->
	<div class="apDiv16">
		<!--logo-->
		<div class="logo">
			<img src="" />
		</div>
		<!--导航栏-->
	</div>
	<!--版权-->
	<div class="四人">
		<div class="apDiv17">
			<img src="img/四人.jpeg">
		</div>
		<div class="xx">
			信计一班<br /> 柯坤程<br /> 柯坤程<br />刘江<br />许柏川 <br /> 张超龙 <br />
		</div>
</body>
</html>