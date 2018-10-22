<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Department</title>
</head>
<body>
	<form:form action="searchResultsByDepartment.obj" method="POST"
		modelAttribute="departmentListObject">
		<table align="center">
			<tr>
				<td>Select Departments</td>
				<td><form:checkboxes items="${departmentListObject.departments}"
				path="departments"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form:form>
	
				
</body>
</html>