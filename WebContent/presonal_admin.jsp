<%@page import="org.User.entity.Manage"%>
<%@page import="org.User.entity.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息表</title>
<link href="./css/presonal_admin.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<%
Manage manage=(Manage)request.getAttribute("manage");
%>
<div id="apDiv1"></div>
<div id="apDiv2"></div>
<div id="apDiv3">姓名：<%=manage.getName() %></div>
<div id="apDiv4">编号：<%=manage.getIden_id() %></div>
<div id="apDiv5">电话号码:<%=manage.getTelnumber() %></div>
<div id="apDiv6">个人信息表</div>


</body>
</html>