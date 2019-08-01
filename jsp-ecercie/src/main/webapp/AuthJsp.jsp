<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>


<style>
body {
font-family: Arial, Helvetica, sans-serif;
text-align: -moz-center;
padding-top: 20px;
background: #fafdff;
}
h2{
color: #27ae60;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #27ae60;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 10%;
  border-radius: 50%;
}

.container {
  padding: 16px;
  width: 30%;
  background: #efefef;
  border-radius: 10px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
label b {
display: flex;
margin-top: 10px;
}

/* unvisited link */
a:link {
  color: red;
}

/* visited link */
a{
margin: 10px;
}
a:visited {
  color: #27ae60;
}

/* mouse over link */
a:hover {
  color: hotpink;
}

/* selected link */
a:active {
  color: blue;
}
#linkes{
display: inline-flex;
}
</style>

</head>
<body>

<h2>Authentification With JSP :)</h2>

<form action="Welcome.jsp" method="POST">
  <div class="imgcontainer">
    <img src="http://www.bordeaux.fr/images/ebx/fr/organisme/87792/W322002571_20190410_1.png" alt="Avatar" class="avatar">
  </div>
  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>
  </div>
</form>


<div id="linkes">
<p><b><a href="AuthForm.html">Authentification With Servlet</a></b></p>
</div>

</body>
</html>