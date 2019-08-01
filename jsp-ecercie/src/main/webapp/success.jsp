<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
text-align: center;
}
h1{
color: #27ae60;
margin-top: 40px;
}
hr{
margin-top: 20px;
color: #27ae60;
}
</style>
</head>
<body>

<h1>Authentification From JSP </h1>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#27ae60">
<td><b>Username</b></td>
<td><b>Password</b></td>
</tr>

<tr bgcolor="#00b894">

  <% 
  String username = request.getParameter("username"); 
  String password = request.getParameter("password");
  %> 
  
<td><%=username%> </td>
<td><%=password%> </td>
</tr>

</table>

<hr>
</body>
</html>