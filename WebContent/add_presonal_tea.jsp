
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加老师信息</title>
<link href="./css/add_presonal_tea.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<%
		String count = String.valueOf(request.getAttribute("result"));
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
			if (count.equals("4")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("电话号码格式不正确！");// 弹出错误信息
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
		}
	%>

	<div id="apDiv1"></div>
	<div id="apDiv2"></div>
<form name="form1" method="post" action="tea_addtea_servlet?sf=老师&id=0&pwd=6666666  ">
	<div id="apDiv3">
		姓名：<input type="text" id="mydiv" name="name" placeholder="请输入教师名字" ></div>
  <div id="apDiv4">编号：
		  <input type="text" id="mydiv" name="iden_id" placeholder="请输入教师编号" ></div>
	
		<div id="apDiv5">
			电话号码:<input type="text" id="mydiv" name="number" placeholder="请输入11位的电话号码"
				 height="40px" />
		</div>
  <div id="apDiv6">个人信息表</div>
		<div id="apDiv7">
			出生日期：<input type="text" id="mydiv" name="birth" value=<%="2000-01-06"%>
				height="30px" />
		</div>
  <div id="apDiv8">
			班级：<input type="text" id="mydiv" name="bj" height="30px" />
		</div>
		<div id="apDiv10">
			家庭住址：<input type="text" id="mydiv" name="address" 
				height="30px" />
  </div>
		<input type="submit" id="apDiv14" value="添加教师">

	<div id="apDiv11">
		性别:<input type="text" id="mydiv" name="sex" value=<%="男"%> height="30px" />
	</div>
	
</form>
	
	
</body>
</html>