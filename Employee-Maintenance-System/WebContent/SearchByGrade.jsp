<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/styles.css">
		<title>Search By Grade</title>
	</head>
	<body>
		<h1>Search Employee By Grade</h1>
		<form:form action="searchResultsByGrade.obj" method="POST"
			modelAttribute="gradeListObject">
			<table>
				<tr>
					<td>Select Grades</td>
					<td><form:checkboxes class="checkboxes" items="${gradeList}"
					path="grades"/></td>
				</tr>
				<tr>
					<td><input class="inputBtn" type="submit" value="Submit"></td>
					<td><input class="inputBtn" type="reset" value="Clear"></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>