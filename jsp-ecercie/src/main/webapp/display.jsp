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
color: #0097e6;
margin-top: 40px;
}
hr{
margin-top: 20px;
color: #0097e6;
}
</style>
</head>
<body>


<h1>Authentification From Servlet </h1>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor=#0097e6>
<td><b>Username</b></td>
<td><b>Password</b></td>
</tr>

<tr bgcolor="#54a0ff">

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