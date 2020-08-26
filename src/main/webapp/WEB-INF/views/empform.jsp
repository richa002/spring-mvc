<%-- 
    Document   : empform
    Created on : 11 Jun, 2020, 5:00:54 AM
    Author     : Acer
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ include file="index.jsp" %>  
  
    <body>
        
        <h1>Add New Employee</h1>  
        <form action="save" >
        Name: <input type="text" name="name" />
	
	Salary: <input type="number" name="salary" />
	
	Designation: <input type="text" name="designation" />

	<input type="submit" value="Save" />
        </form>
        <br><br>
        ${msg}
        
         </body>
</html>
