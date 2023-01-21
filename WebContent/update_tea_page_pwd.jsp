<%@page import="org.User.entity.Teacher"%>
<%@page import="org.User.entity.Manage"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>
</head>



<style type="text/css">
@CHARSET "UTF-8";
#apDiv1 {
	position: absolute;
	left: 29px;
	top: 17px;
	width: 770px;
	height: 820px;
	z-index: 1;
	background-image: url(image/信息.jpeg);
}
#apDiv2 {
	position: absolute;
	left: 160px;
	top: 114px;
	width: 344px;
	height: 61px;
	z-index: 2;
}
#apDiv3 {
	position: absolute;
	left: 164px;
	top: 199px;
	width: 342px;
	height: 59px;
	z-index: 3;
}
#apDiv4 {
	position: absolute;
	left: 162px;
	top: 286px;
	width: 345px;
	height: 62px;
	z-index: 4;
}
#apDiv5 {
	position: absolute;
	left: 187px;
	top: 442px;
	width: 112px;
	height: 56px;
	z-index: 5;
	background-color: #00CCCC;
	font-weight: bold;
	font-size: 36px;
	text-align: center;
}
#apDiv6 {
	position: absolute;
	left: 362px;
	top: 444px;
	width: 121px;
	height: 55px;
	z-index: 6;
	background-color: #33FF99;
	font-size: 36px;
	font-weight: bold;
	text-align: center;
}
#apDiv7 {
	position: absolute;
	left: 252px;
	top: 44px;
	width: 158px;
	height: 49px;
	z-index: 7;
	font-size: 36px;
	font-weight: bold;
}
</style>

</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
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
		action="tea_updatetea_servlet?id=<%=tea.getId() %>&operate=修改密码">
		<div id="apDiv1"></div>
		<div id="apDiv2">
			原密码：<input type="password" name="oldpwd" height="30px" />
		</div>
		<div id="apDiv3">
			新密码：<input type="password" name="newpwd1" height="30px" />
		</div>
		<div id="apDiv4">
			再次确认：<input type="password" name="newpwd2" height="30px" />
		</div>
		<div id="apDiv7">修改密码</div>
		<input type="submit" id="apDiv5" value="确认">
	</form>

	<a href="tea_Querytea_servlet?operate=修改&id=<%=tea.getId() %>"><div id="apDiv6">返回</div></a>
</body>
</html>