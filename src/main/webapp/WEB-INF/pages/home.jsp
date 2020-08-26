<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
   <title>Employee Management Screen</title>
</head>
<body>
    <div align="center">
        
        <h2> 
           ${msg}
</h2>
        <h1>Employee List</h1>
        <h3>
            <a href="/springmvchibernate/newEmployee">New Employee</a>
        </h3>
        <table border="1">
 
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>
 
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
 
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>${employee.telephone}</td>
                    <td><a href="/springmvchibernate/editEmployee?id=${employee.id}">Edit</a>
                             <a
                        href="/springmvchibernate/deleteEmployee?id=${employee.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
