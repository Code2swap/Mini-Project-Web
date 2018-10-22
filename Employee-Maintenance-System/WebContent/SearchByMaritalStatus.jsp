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
	<form:form action="searchResultsByMarital.obj" method="POST"
		modelAttribute="maritalListObject">
		<table align="center">
			<tr>
				<td>Select Marital Status</td>
				<td><form:checkboxes items="${maritalListObject.maritals}"
				path="maritals"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form:form>
	
				
</body>
</html>