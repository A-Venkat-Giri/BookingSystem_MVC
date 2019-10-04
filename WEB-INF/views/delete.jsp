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
 <h1>Delete Account</h1>
 <div class="form-group">
<form action="./delete" method="post">
<h3>For Authentication Enter User Id and Password</h3>
<input class="form-control" type="text" name="userId"/><br>
<label name = "password">Password</label>
<input class = "form-control" type = "password" name = "password"><br>
<input class = "form-control" type = "submit" value="DeleteAccount">
</form>
</div>
</div>
</div>
</body>
</html>