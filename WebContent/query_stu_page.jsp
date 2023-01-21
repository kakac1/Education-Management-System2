<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="./css/query_stu_page.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="apDiv1"></div>
<form name="form1" method="post" action="Queryallstu_tea_servlet?page_num=1"    target="frm">
<div id="apDiv2"><input type="text" id="mydiv" name="query" id="query"   placeholder="请输入查询内容" height="30px" /></div>
<div id="apDiv3" ><input type="submit"  name="submit" value="查询" style="width: 121px; height: 36px"></div>
<div id="apDiv4">
  <p>
    <label>
      <input type="radio" name="chooise" value="all" id="RadioGroup1_0">
      全体</label>

    <label>
      <input type="radio" name="chooise" value="bj" id="RadioGroup1_1">
      班级</label>

    <label>
      <input type="radio" name="chooise" value="name" id="RadioGroup1_2">
      姓名</label>

    <label>
      <input type="radio" name="chooise" value="sex" id="RadioGroup1_3">
      性别</label>
 
    <label>
      <input type="radio" name="chooise" value="tea" id="RadioGroup1_4">
      老师</label>
 
  </p>
</form></div>
<iframe id="apDiv5" name="frm"> </iframe>

</body>
</html>