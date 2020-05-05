<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="login" method ="Post">
<h2> User Login : </h2>
<pre>
User Name : <input type = "email" name = "email"/>
Password : <input type = "password" name = "password"/>
<input type = "submit" value = "login"/>
Don't have an account. <a href="showReg"></a>
${msg}
</pre>
</form>
</body>
</html>