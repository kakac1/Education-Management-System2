<%@page import="org.User.entity.Teacher"%>

<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>
<link href="./css/update_tea_page.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%
		Teacher tea = (Teacher) request.getAttribute("tea");
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
		姓名：<%=tea.getName()%></div>
	<div id="apDiv4">
		编号：<%=tea.getIden_id()%></div>
	<form name="form1" method="post"
		action="tea_updatetea_servlet?id=<%=tea.getId()%>&operate=修改信息&sf=<%=tea.getSf()%>&name=<%=tea.getName()%>&iden_id=<%=tea.getIden_id()%>&sex=<%=tea.getSex()%>&pwd=<%=tea.getPwd()%>">
		<div id="apDiv5">
			电话号码:<input type="text" id="mydiv" name="telnumber" placeholder="请输入11位的电话号码"
				value=<%=tea.getTelnumber()%> height="40px" />
		</div>
		<div id="apDiv6">个人信息表</div>
		<div id="apDiv7">
			出生日期：<input type="text" id="mydiv" name="birth" value=<%=tea.getBirth()%>
				height="30px" />
		</div>
		<div id="apDiv10">
			家庭住址：<input type="text" id="mydiv" name="address" value=<%=tea.getAddress()%>
				height="30px" />
		</div>
		<div id="apDiv13">
			身份：<%=tea.getSf()%>

		</div>
		<input type="submit" id="apDiv14" value="修改信息">

	</form>
	<div id="apDiv11">
		性别:<%
		if (tea.getSex().equals("m")) {
			out.print("男");
		} else {
			out.print("女");
		}
	%>
	</div>
	<a href="tea_Querytea_servlet?operate=修改密码&id=<%=tea.getId() %> " target="右frm"><div id="apDiv15">修改密码</div></a>
</body>
</html>