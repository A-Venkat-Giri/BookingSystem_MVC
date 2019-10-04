<%@page import="java.io.PrintWriter"%>
<%@page import="com.dev.bss.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
    rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/Spring.css"
    rel="stylesheet"> 
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
    <div class = "form-group">
 <h1>Search Bus</h1>
<label name = "userId">Write Feedback</label>
<form  action = "./feedback" method = "post">
<input class="form-control" type="text" name="fb"/><br>
<input class="form-control" type = "submit" value="Submit Feedback">
</form>
</div>
</div>
</div>
</body>
</html>