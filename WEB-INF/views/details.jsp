<%@page import="com.dev.bss.beans.User"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
    rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/Spring.css"
    rel="stylesheet"> 
<title>Home</title>

</head>
<body>

<%@ include file="loginheader.jsp" %>
 <%  
     User user = (User) session.getAttribute("details");
    if(user != null)
    {
    	PrintWriter output = response.getWriter();
    	output.println("<h1> Welcome "+user.getUserName()+" </h1>");
    	
    	
    }
    else
    {
    	response.sendRedirect("./login");
    }
 
 %>  
 <div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
		<div class="form-group">
			<form action="./book" method="post">
				<!-- <label name = "userId">User Id</label>
<input type="text" name="userId"/><br> -->
				<label name="source">Source</label> <input class = "form-control" type="text" name="source" /><br>
				<label name="destination">Destination</label> <input type="text" class = "form-control"
					name="destination" /><br> <label name="date">Date</label> <input class ="form-control"
					type="text" name="date"><br> <input type="submit"
					value="Search Buses">
			</form>
			</div>
		</div>
	</div>
 
</body>
</html>