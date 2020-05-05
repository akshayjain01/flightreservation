<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>

<form action = "registerUser" method = "post">
<h2> USER REGISTRATION : </h2>
<pre>
First Name: <input type = "text" name = "firstName"/>
Last Name: <input type = "text" name = "lastName"/>
User Name: <input type = "email" name = "email"/>
Password: <input type = "password" name = "password"/>
Confirm Password: <input type = "password" name = "confirmPassword"/>
<input type = "submit" value = "register"/>
Already have an account. <a href="login">LOGIN</a>
</pre>
</form>

</body>
</html>