<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/index_page.css" rel="stylesheet" type="text/css"/>

<title>登陆首页</title>

</head>
<body>

	<%
	    String count = String.valueOf( request.getAttribute("count"));
		if (count != null) {
			if (count.equals("2")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("密码错误！");// 弹出错误信息
		//window.location = 'index_page.jsp';// 跳转到登录界面
	</script>
	<%
		}
			if (count.equals("3")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("该账号不存在！");// 弹出错误信息
		//window.location = 'index_page.jsp';// 跳转到登录界面
	</script>
	<%
		}
			if (count.equals("4")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("验证码错误！");// 弹出错误信息
		//window.location = 'index_page.jsp';// 跳转到登录界面
	</script>
	<%
		}
			if (count.equals("5")) {
	%>
	<script type="text/javascript" language="javascript">
		alert("系统异常！");// 弹出错误信息
		//window.location = 'index_page.jsp';// 跳转到登录界面
	</script>
	<%
		}

		}
	%>
	
	<video id="v1" muted="muted" autoplay="autoplay" loop="loop"> <source src="sea.mp4"></video>
	<form name="form1" method="post" action="Login_servlet" >
		<div id="apDiv7">
			<div id="apDiv1">
				账号:<input type="text" name="zh" id="zhanghao"   placeholder="请输入账号"
					height="30px" />
			</div>
			<div id="apDiv2">
				密码:<input type="password" name="pwd" id="pass" placeholder="请输入密码"
					height="30px" />
			</div>
			<div id="apDiv8">
				验证码:<input type="text"   id='pass1'   name="newyzm" placeholder="验证码"
					height="30px" />
			</div>
			<div id="apDiv11">
				<img src="code.jsp" onclick="this.src=this.src+'?'+Math.random()"
					width="120px" high="40px">
			</div>
			<div id="apDiv5">
				<p>
					<label> <input type="radio" name="id" value="学生" id="身份_0" />
						学生
					</label> <label> <input type="radio" name="id" value="老师" id="身份_1" />
						老师
					</label> <label> <input type="radio" name="id" value="管理员"
						id="身份_2" /> 管理员
					</label>
				</p>

			</div>
			<div id="apDiva">
				<input type="submit" name="submit" value="登录"
					style="width: 158px; height: 34px">
			</div>
		</div>
	</form>

</body>
</html>