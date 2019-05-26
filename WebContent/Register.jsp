<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页</title>
</head>
<body>
<form action="RegServlet"  method="post">
姓名：<input type="text" id="name" name="name"><br>
手机号码：<input type="text"  id="phone" name="phone"><br>
密码：<input type="password" id="password" name="password"><br>
<button type="submit" >注册</button>
</form>
<!-- <script type="text/javascript">
function checkPassword() {
	var name=document.getElementBtId("name").value;
	var phone=document.getElementBtId("phone").value;
	var password=document.getElementBtId("password").value;
	var errorMessage;
	if(name==""){
	/* 	errorMessage=document.getElementById("errorMessage");
		errorMessage.innerHTML="请输入用户名" */
		alert("用户名不能为空")
	}
	if(phone==""){
		errorMessage=document.getElementById("errorMessage");
		errorMessage.innerHTML="请输入手机号码"
	}
	if(password==""){
		errorMessage=document.getElementById("errorMessage");
		errorMessage.innerHTML="请输入密码"
	}
}
</script> -->
</body>
</html>