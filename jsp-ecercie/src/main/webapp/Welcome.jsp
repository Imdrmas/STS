<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
String username=request.getParameter("username");
String password=request.getParameter("password");
if(username.equals("admin") && password.equals("admin123"))
{
	
	 request.setAttribute("username",username);
	 request.setAttribute("password",password);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
	    if (dispatcher != null){
	            dispatcher.forward(request, response);
	    } 

}
else {
response.sendRedirect("error.jsp");
}
%>



</body>
</html>