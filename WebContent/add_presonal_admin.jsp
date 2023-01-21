
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>

<link href="./css/add_presonal_admin.css" rel="stylesheet" type="text/css"/>
</head>



<body>

	<%
		String count = String.valueOf(request.getAttribute("count"));
		if (count != null) {
			if (count.equals("1")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("添加成功！");// 弹出错误信息
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
			if (count.equals("3")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("编号已存在！");// 弹出错误信息
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
<form name="form1" method="post" action="manage_addmanage_servlet?id=0&credit=1&pwd=999999&sf=管理员">
	<div id="apDiv3">
		姓名：<input type="text" id="mydiv" name="name" placeholder="请输入管理员名字" ></div>
  <div id="apDiv4">编号：
		  <input type="text" id="mydiv" name="iden_id" placeholder="请输入管理员" ></div>
	
  <div id="apDiv5">
			电话号码:<input type="text" id="mydiv" name="number" placeholder="请输入11位的电话号码"
				value=<%="null"%> height="40px" />
		</div>
		<div id="apDiv6">个人信息表</div>
		<input type="submit" id="apDiv14" value="添加管理员" >
</form>
	
	
</body>
</html>