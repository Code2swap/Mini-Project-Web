<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/styles.css">
		<title>Search By Marital Status</title>
	</head>
	<body>
		<h1>Search Employee By Marital Status</h1>
		<form:form action="searchResultsByMarital.obj" method="POST"
			modelAttribute="maritalListObject">
			<table>
				<tr>
					<td>Select Marital Status</td>
					<td><form:checkboxes class="checkboxes" items="${maritalList}"
					path="maritals"/></td>
				</tr>
				<tr>
					<td><input class="inputBtn" type="submit" value="Submit"></td>
					<td><input class="inputBtn" type="reset" value="Clear"></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>