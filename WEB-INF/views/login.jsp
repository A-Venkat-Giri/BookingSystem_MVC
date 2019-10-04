<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/Spring.css"
	rel="stylesheet">
<title>Login</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<h1>Login</h1>
			<div class="form-group">
			<form action="./login" method="post">
				<label name="userId">User Id</label> <input type="text"
					name="userId" class = "form-control" /><br> <label name="password">Password</label> 
					<input class="form-control" type="password" name="password"><br> 
					<input type="submit" value="Login">
			</form>
		</div>
	</div>
	</div>
</body>
</html>