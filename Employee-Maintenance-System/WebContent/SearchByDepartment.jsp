<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/styles.css">
		<title>Search By Department</title>
	</head>
	<body>
		<h1>Search Employee By Department</h1>
		<form:form action="searchResultsByDepartment.obj" method="POST"
			modelAttribute="departmentListObject">
			<table>
				<tr>
					<td>Select Departments:</td>
					<td><form:checkboxes cssClass="checkboxes" items="${departmentList}"
					path="departments"/></td>
				</tr>
				<tr>
					<td><input class="inputBtn" type="submit" value="Submit"></td>
					<td><input class="inputBtn" type="reset" value="Clear"></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>