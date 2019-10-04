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
<%@ include file="adminheader.jsp" %>
<div class="col-md-4 offset-4 mt-4 card">
    <div class="card-body">
    <h1>Add Bus</h1>
    <div class="from-group">
<form action="./addbus" method="post">
<label name = "busName">Bus Name</label>
<input  class = "form-control" type="text" name="busName"/><br>
<label name = "busType">Bus Type</label>
<input  class = "form-control" type = "text" name = "busType"><br>
<label name = "source">Source</label>
<input  class = "form-control" type = "text" name = "source"><br>
<label name = "destination">Destination</label>
<input  class = "form-control" type = "text" name = "destination"><br>
<label name = "price">Price</label>
<input  class = "form-control" type = "text" name = "price"><br>
<label name = "totalSeats">Total Seats</label>
<input  class = "form-control" type = "text" name = "totalSeats"><br>
<input  class = "form-control" type = "submit" value="Add Bus">
</form>
</div>
</div>
</body>
</html>