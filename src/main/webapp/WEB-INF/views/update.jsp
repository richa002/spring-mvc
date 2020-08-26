<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Update</title>
</head>
<body>
   
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Update Here | <a href="./read">Click for Read</a></strong></p>
<form action="edit" method="post" >

 
    <pre>
    Id:    	<input type="text" name="dispId" value="${list.get(0).id}" disabled="disabled"/><br>
		<input type="hidden" name="id" value="${list.get(0).id}"/>
			
    Name:  	<input type="text" name="name" value="${list.get(0).name}" /><br>

		
    SALARY: 	<input type="text" name="salary" value="${list.get(0).salary}" /><br>

	    
   DESIGNATION:	<input type="text" name="designation" value="${list.get(0).designation}" /><br>
        <input type="submit" value="Update" />	
</pre>
</form>
${msg}
</body>
</html>