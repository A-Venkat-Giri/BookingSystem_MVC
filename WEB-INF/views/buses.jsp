<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/Spring.css"
	rel="stylesheet">

<body>
	<h1>Available Buses</h1>
	${buses}

	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<h4>Enter Bus Id</h4>
			<div class="form-group">
			<form action="./select" method="post">
				<label name="busId">Bus Id</label> <input class="form-control" type="text" name="busId"><br>
				<label name="number">Number of SEATS</label> <input type="text" class="form-control"
					name="number"> <br>
					<input type="submit" value="Proceed">
			</form>
		</div>
		</div>
	</div>
</body>
</html>