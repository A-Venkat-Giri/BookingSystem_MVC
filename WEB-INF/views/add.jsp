<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
    rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/Spring.css"
    rel="stylesheet"> 
</head>
<body>
<%@ include file="header.jsp" %>
<div class="col-md-4 offset-4 mt-4 card">
    <div class="card-body">
    <h1>Register</h1>
    <div class="from-group">
<form action="./add" method="post">
<label name = "userName">User Name</label>
<input class="form-control" type="text" name="userName"/><br>
<label name = "password">Password</label>
<input class="form-control" type = "password" name = "password"><br>
<label name = "email">Email</label>
<input class="form-control" type = "email" name = "email"><br>
<label name = "contact">Contact</label>
<input class="form-control"  type = "text" name = "contact"><br>
<input class="form-control" type = "submit" value="Register">
</form>
</div>
</div>
</body>
</html>