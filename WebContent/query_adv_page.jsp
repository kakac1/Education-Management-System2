<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./css/query_adv_page.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="apDiv1"></div>
<form name="form1" method="post" action="adv_Queryalladv_serlvet?page_num=1"    target="frm">
<div id="apDiv2"><input type="text" id="mydiv" name="query" id="query"   placeholder="请输入查询内容" height="30px" /></div>
<div id="apDiv3" ><input type="submit" name="submit" value="查询" style="width: 121px; height: 43px"></div>
<div id="apDiv4">
  <p>
    <label>
      <input type="radio" name="chooise" value="all" id="RadioGroup1_0">
      全体</label>

    <label>
      <input type="radio" name="chooise" value="sf" id="RadioGroup1_1">
      身份</label>
  </p>
</form></div>
<iframe id="apDiv5" name="frm"> </iframe>

</body>
</html>