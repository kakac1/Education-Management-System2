<%@page import="org.User.entity.Teacher"%>
<%@page import="org.User.entity.Student"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/adv_page.css" rel="stylesheet" type="text/css"/>
<title>匿名发表建议</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		Teacher tea= (Teacher) request.getAttribute("tea");
		String count = String.valueOf(request.getAttribute("count"));
		if (count != null) {
			if (count.equals("1")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("发表成功！");// 弹出错误信息
	</script>

	<%
		}
		}
	%>



	<div id="apDiv1"></div>
	<div id="apDiv3">匿名发表建议</div>


	<form name="my_Form" method="POST"
		action="adv_addAdv_servlet?id=<%=tea.getId() %>&number=<%=tea.getTelnumber() %>&sf=<%=tea.getSf() %>">
		<div id="apDiv4">
			<textarea style="width: 617px; height: 132px; resize: none"
				placeholder="请输入你的建议...." name="adv"></textarea>
		</div>

		<input type="submit" id="apDiv5" value="提交">
	</form>


	<!-- <div id="apDiv6">返回</div> -->
</body>
</html>