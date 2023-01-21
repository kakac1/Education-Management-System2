<%@page import="org.Dao.Pic"%>
<%@page import="org.User.entity.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/presonal_stu.css" rel="stylesheet" type="text/css"/>
<title>个人信息表</title>

</head>
<body>
<%
Student stu=(Student)request.getAttribute("student");
String pic=Pic.Querypic(stu.getxh());

%>

<div id="apDiv1"></div>
<div id="apDiv2" style="background:url(upload/<%=pic%> ) ;width: 312px;height: 295px;"> </div>
<div id="apDiv3">姓名：<%=stu.getUname() %></div>
<div id="apDiv4">学号：<%=stu.getxh() %></div>
<div id="apDiv5">电话号码:<%=stu.getNumber() %></div>
<div id="apDiv6">个人信息表</div>
<div id="apDiv7">出生日期：<%=stu.getBirth() %></div>
<div id="apDiv8">班级：<%=stu.getbj() %></div>
<div id="apDiv9">号数：<%=stu.getNum() %></div>
<div id="apDiv10">家庭住址：<%=stu.getAddress() %></div>
<div id="apDiv11">性别:<%
if(stu.getSex().equals("m")){
	out.print("男");
}else{
	out.print("女");
}

%></div>
<div id="apDiv12">学分：<%=stu.getCredit() %></div>
<div id="apDiv13">老师：<%=stu.gettea() %></div>
</body>
</html>