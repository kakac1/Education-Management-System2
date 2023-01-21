<%@page import="org.Dao.Pic"%>
<%@page import="org.User.entity.Student"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改个人信息表</title>
<link href="./css/update_stu_page.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<%
		Student stu = (Student) request.getAttribute("student");
		String count = String.valueOf(request.getAttribute("count"));
		String pic=Pic.Querypic(stu.getxh());
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
	<div id="apDiv2" style="background: url(background:url(upload/<%=pic %> ) ;width: 312px;height: 295px;)"></div>

	<div id="apDiv3">
		姓名：<%=stu.getUname()%></div>
	<div id="apDiv4">
		学号：<%=stu.getxh()%></div>
	<form name="form1" method="post"
		action="updatestu?id=<%=stu.getId()%>&operate=修改信息&sf=<%=stu.getSf()%>&Uname=<%=stu.getUname()%>&xh=<%=stu.getxh()%>&sex=<%=stu.getSex()%>&credit=<%=stu.getCredit()%>&password=<%=stu.getPassword()%>">
		<div id="apDiv5">
			电话号码:<input type="text" id="mydiv" name="number"
				placeholder="请输入11位的电话号码" value=<%=stu.getNumber()%> height="40px" />
		</div>
		<div id="apDiv6">个人信息表</div>
		<div id="apDiv7">
			出生日期：<input type="text" id="mydiv" name="birth"
				value=<%=stu.getBirth()%> height="30px" />
		</div>
		<div id="apDiv8">
			班级：<input type="text" id="mydiv" name="bj" value=<%=stu.getbj()%>
				height="30px" />
		</div>
		<div id="apDiv9">
			号数：<input type="text" id="mydiv" name="num" value=<%=stu.getNum()%>
				height="30px" />
		</div>
		<div id="apDiv10">
			家庭住址：<input type="text" id="mydiv" name="adDress"
				value=<%=stu.getAddress()%> height="30px" />
		</div>
		<div id="apDiv13">
			老师：<input type="text" id="mydiv" name="tea" value=<%=stu.gettea()%>
				height="30px" />
		</div>
		<input type="submit" id="apDiv14" value="修改信息">

	</form>
	<div id="apDiv11">
		性别:<%
		if (stu.getSex().equals("m")) {
			out.print("男");
		} else {
			out.print("女");
		}
	%>
	</div>
	<a href="stu_Querystu_servlet?operate=修改密码&id=<%=stu.getId()%> "
		target="右frm"><div id="apDiv15">修改密码</div></a>
	<div id="apDiv12">
		学分：<%=stu.getCredit()%></div>




	<div id="apDivaa" align="center">
		<form
			action="upload_servlet?xh=<%=stu.getxh() %>&name=<%=stu.getUname()%>"
			method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>上传资料</td>
					<td><input id="file1" type="file" name="pic"
						accept="image/gif,image/jpeg,image/jpg,image/png,image/svg">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input id="button"
						type="submit" value="上传"></td>
				</tr>
			</table>
		</form>

		<form action="get_pic_servlet" method="post">
			<table>
				<tr>
					<td>查看上传头像</td>
					<td><input type="text" id="mydiv" name="filename"
						accept="image/gif,image/jpeg,image/jpg,image/png,image/svg">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input id="button" id="mydiv"
						type="submit" value="查看"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>