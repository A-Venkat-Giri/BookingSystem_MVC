<%@page import="com.dev.bss.beans.Admin"%>
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
 
</body>
</html>