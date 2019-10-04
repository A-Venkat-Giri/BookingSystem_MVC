<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
    rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/Spring.css"
    rel="stylesheet"> 
<%@ include file="adminheader.jsp" %>
<div class="col-md-4 offset-4 mt-4 card">
    <div class="card-body">
    <h1>Update Bus</h1>
    <div class = "form-group">
 <form action="./available" method="post">
<label name = "seats">Available Seats</label>
<input class="form-control" type = "text" name = "seats"><br>
<label name = "date">Date</label>
<input class="form-control" type = "text" name = "date"><br>
<input class="form-control" type = "submit" value="Add">
</form>
</div>
</div>
</div>
</body>
</html>