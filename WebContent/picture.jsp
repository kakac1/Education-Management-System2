<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="upload_servlet" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>学号：</td>
					<td><input id="sno" type="text" name="sno">
					</td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input id="name" type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>选择上传的图片</td>
					<td><input id="file1" type="file" name="pic" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg">>
					</td>
				</tr>				
				<tr>
					<td align="center" colspan="2"><input id="button"
						 type="submit" value="上传" > 
					</td>
				</tr>
			</table>
		</form>
	</div>
	<a id="a"
						href="get_pic_servlet?filename=顺序图.jpg">查看上传图片</a>
</body>
</html>