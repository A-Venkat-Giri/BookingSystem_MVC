<%@page import="com.dev.bss.beans.Admin"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.dev.bss.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
    rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/Spring.css"
    rel="stylesheet"> 

</head>
<body>
<%@ include file="adminheader.jsp" %>
<%  
     Admin user = (Admin) session.getAttribute("detailsadmin");
    if(user != null)
    {
    	PrintWriter output = response.getWriter();
    	output.println("<h1> Welcome "+user.getAdminId()+" </h1>");
    	
    }
    else
    {
    	response.sendRedirect("./adminlogin");
    }
 
 %>
 <div class="col-md-4 offset-4 mt-4 card">
 <div class="card-body">
 <div class = "form-group">
<form action="./deletebus" method="post">
<h3>Delete Bus</h3>
<label name = "busId">User Id</label>
<input class="form-control" type="text" name="busId"/><br>
<label name = "password">Password</label>
<input class = "form-control" type = "password" name = "password"><br>
<input class = "form-control" type = "submit" value="Delete Bus">
</form>
</div>
</div>
</div>
</body>
</html>