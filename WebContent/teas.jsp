<%@page import="org.User.entity.Teacher"%>
<%@page import="org.User.entity.Student"%>
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
    List<Teacher> userlist=(List<Teacher>)request.getAttribute("userlist");
    String nr=request.getParameter("nr");
    String chooise=request.getParameter("chooise");
    
    
    
    
//    User1 user3=new User1();
//    user3.setId(1);
 //   user3.setUsername("ss");
 //   user3.setPassword("skjda");
 //   userlist3.add(user3);
  //  User1 user4=new User1();
 //   user4.setId(1);
 //   user4.setUsername("ss");
  //  user4.setPassword("skjda");
    //userlist3.add(user4);

    
   // while(rs.next()){
   // user2.setId(1);
   // user2.setUsername("ss");
  //  user2.setPassword("skjda");
  //  userlist1.add(user2);
  //  System.out.println(userlist1);
    
    
   %>
<%-- <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>ID</th>
  		</tr>
	<c:forEach var="U" items="${userlist}" > 
	<tr>
	
      ${U.id}
	   
	 
    </c:forEach>  
 
    
    </table> --%>
	<table border="1px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>家庭地址</th>
			<th>电话号码</th>
		</tr>
		<%
			for (Teacher tea : userlist) {
		%>
		<tr>
			<td><%=tea.getIden_id() %></td>
			<td><%=tea.getName() %></td>
			<td>
				<%
					if (tea.getSex().equals("m")) {
				%> <%='男'%> <%
 	} else if (tea.getSex().equals("f")) {
 %> <%='女'%> <%
 	}
 %>
			</td>
			<td><%=tea.getBirth()%></td>
			<td><%=tea.getAddress()%></td>
			<td><%=tea.getTelnumber() %></td>
			<td><a href="delstu_servelt?id=<%=tea.getId()%>&nr=<%=nr%>&chooise=<%=chooise%>">删除</a></td>
		</tr>



		<%

}



%>
	</table>





</body>
</html>