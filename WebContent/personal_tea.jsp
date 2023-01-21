<%@page import="org.User.entity.Teacher"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息表</title>

<link href="./css/personal_tea.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
Teacher tea=(Teacher)request.getAttribute("tea");
%>
<div id="apDiv1"></div>
<div id="apDiv2"></div>
<div id="apDiv3">姓名：<%=tea.getName() %></div>
<div id="apDiv4">编号：<%=tea.getIden_id() %></div>
<div id="apDiv5">电话号码:<%=tea.getTelnumber() %></div>
<div id="apDiv6">个人信息表</div>
<div id="apDiv7">出生日期：<%=tea.getBirth() %></div>
<div id="apDiv10">家庭住址：<%=tea.getAddress() %></div>
<div id="apDiv11">性别:<%
 if(tea.getSex().equals("m")){
	out.print("男");
}else{
	out.print("女");
} 
%></div>
<div id="apDiv12">身份：<%=tea.getSf()   %></div>
</body>
</html>