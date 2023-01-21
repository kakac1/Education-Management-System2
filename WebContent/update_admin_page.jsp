<%@page import="org.User.entity.Manage"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>

<link href="./css/update_admin_page.css" rel="stylesheet" type="text/css"/>


</head>

<body>
	<%
		Manage manage = (Manage) request.getAttribute("manage");
		String count = String.valueOf(request.getAttribute("count"));
		if (count != null) {
			if (count.equals("1")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("修改成功！");// 弹出错误信息
	</script>

	<%
		}
			if (count.equals("2")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("系统异常！");// 弹出错误信息
	</script>

	<%
		}
			if (count.equals("4")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("电话号码格式不正确！");// 弹出错误信息
	</script>
	<%
		}
			if (count.equals("5")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("密码格式不正确！");// 弹出错误信息
	</script>
	<%
		}
		}
	%>
	<div id="apDiv1"></div>
	<div id="apDiv2"></div>

	<div id="apDiv3">
		姓名：<%=manage.getName()%></div>
	<div id="apDiv4">
		编号：<%=manage.getIden_id()%></div>
	<form name="form1" method="post"
		action="manage_updatemanage_servelt?id=<%=manage.getId()%>&operate=修改个人信息">
		<div id="apDiv5">
			电话号码:<input type="text" id="mydiv" name="number" placeholder="请输入11位的电话号码"
				value=<%=manage.getTelnumber()%> height="40px" />
		</div>
		<div id="apDiv6">个人信息表</div>
		<input type="submit" id="apDiv14" value="修改信息"> <a
			href="manage_Querymanage_servlet?operate=修改密码&id=<%=manage.getId()%> "
			target="右frm"><div id="apDiv15">修改密码</div></a>
	</form>
</body>
</html>