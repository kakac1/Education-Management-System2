<%@page import="org.Dao.stuDao"%>
<%@page import="org.User.entity.Advise"%>
<%@page import="java.sql.*"%>

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生个人信息表</title>

</head>

<body>
	<%

    request.setCharacterEncoding("utf-8");
    List<Advise> userlist=(List<Advise>)request.getAttribute("userlist");
    String nr=request.getAttribute("nr").toString();
    String chooise=request.getAttribute("chooise").toString(); 
    int count = Integer.parseInt(request.getAttribute("count").toString());
	String a=request.getParameter("page_num");
	if (Integer.parseInt(a) > count||!stuDao.isInteger(a)) {
		a = "1";

	}
	int page_num = Integer.parseInt(a);
	
	if (page_num > count) {
		page_num = 1;

	}
    

    
   %>

	<table border="1px">
		<tr>
			<th>id</th>
			<th>建议</th>
			<th>电话号码</th>
			<th>身份</th>
		</tr>
		<%
			for (Advise adv : userlist) {
		%>
		<tr>
			<td><%=adv.getId() %></td>
			<td><%=adv.getAdv() %></td>
			<td><%=adv.getTelnumber() %></td>
			<td><%=adv.getSf() %></td>
			<td><a
				href=" adv_Deladv_servlet?id=<%=adv.getId() %>&query=<%=nr%>&chooise=<%=chooise%>&page_num=<%=page_num %>">删除</a></td>
		</tr>
		<%

}



%>
	</table>


	共<%=count%>页


	<%
		if (page_num == 1 && page_num < count) {
	%>

	<a
		href="adv_Queryalladv_serlvet?chooise=<%=chooise%>&page_num=<%=page_num + 1%>&query=<%=nr%> ">
		下一页</a>

	<%
		} else if (page_num == count &&page_num!=1) {
	%>
	<a
		href="adv_Queryalladv_serlvet?chooise=<%=chooise%>&page_num=<%=page_num - 1%>&query=<%=nr%> ">
		上一页</a>
	<%
		} else if (page_num < count) {
	%>
	<a
		href="adv_Queryalladv_serlvet?chooise=<%=chooise%>&page_num=<%=page_num - 1%>&query=<%=nr%> ">
		上一页</a>
	<a
		href="adv_Queryalladv_serlvet?chooise=<%=chooise%>&page_num=<%=page_num + 1%>&query=<%=nr%> ">
		下一页</a>

	<%
		}
		if (page_num == 1 && userlist.size() < 10) {
		}
	
		if (page_num!=count) {
	%>

	<form name="form1" method="post"
		action="adv_Queryalladv_serlvet?chooise=<%=chooise%>&query=<%=nr%> ">
		<input type="text" name="page_num" oninput = "value=value.replace(/[^\d]/g,'')" placeholder="第<%=page_num%>页,请输入转页数"
			height="30px" /> <input type="submit" value="跳转">


	</form>

	<%
		}
	%>



</body>
</html>