<%-- 
    Document   : read
    Created on : 13 Jun, 2020, 1:20:44 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%@ include file="index.jsp" %>  
  
    <body>
        
        <h1>Employees List</h1>
        <table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
			<th>Action</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td>${emp.designation}</td>
				<td><a href="update?id=<c:out value='${emp.id}'/>">Update</a> | <a
					href="delete?id=<c:out value='${emp.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
    </body>
</html>
