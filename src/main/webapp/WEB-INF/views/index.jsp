<%-- 
    Document   : index
    Created on : 11 Jun, 2020, 1:44:35 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>${hi}
        
        <h1>SPRING MVC CRUD APPLICATION</h1>
        <a href="/springmvccrud2/empform">Add Employee</a>  <br><BR>
        <a href="/springmvccrud2/read">Get the List of Employee</a>  
  <a href="/springmvccrud2/viewemp?page=1">View Employees(with pagination)</a>   

    </body>
</html>
