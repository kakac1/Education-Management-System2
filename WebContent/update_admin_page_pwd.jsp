<%@page import="org.User.entity.Manage"%>
<%@page import="org.User.entity.Teacher"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>
</head>
<link href="./css/update_admin_page_pwd.css" rel="stylesheet" type="text/css"/>


<body>
	<%
		request.setCharacterEncoding("utf-8");
		Manage manage = (Manage) request.getAttribute("manage");
		out.print(manage);
		String count = String.valueOf(request.getAttribute("count"));
		if (count != null) {
			if (count.equals("1")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("修改成功！");// 弹出错误信息
	</script>

	<%
		}
			if (count.equals("6")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("原密码错误！");// 弹出错误信息
	</script>

	<%
		}
			if (count.equals("7")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("密码确认错误！");// 弹出错误信息
	</script>
	<%
		}
			if (count.equals("5")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("新密码格式不正确！");// 弹出错误信息
	</script>
	<%
		}
		}
	%>
	<form name="form1" method="post"
		action="manage_updatemanage_servelt?id=<%=manage.getId()%>&operate=修改密码">
		<div id="apDiv1"></div>
		<div id="apDiv2">
			原密码：<input type="password" id="mydiv" name="oldpwd" height="30px" />
		</div>
		<div id="apDiv3">
			新密码：<input type="password" id="mydiv" name="newpwd1" height="30px" />
		</div>
		<div id="apDiv4">
			再次确认：<input type="password" id="mydiv" name="newpwd2" height="30px" />
		</div>
		<div id="apDiv7">修改密码</div>
		<input type="submit" id="apDiv5" value="确认">
	</form>

	<a
		href="manage_Querymanage_servlet?operate=修改个人信息&id=<%=manage.getId()%>"><div
			id="apDiv6">返回</div></a>
</body>
</html>