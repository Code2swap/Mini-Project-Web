<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Id</title>
</head>
<body>
	<h1><center>Search Employee By ID</center></h1>
	<form:form action="searchResultsById.obj">
		<table align="center">
			<tr>
				<td>Enter id to search :</td>
				<td><input type="text" name="searchId" /></td>
			</tr>

			<tr>
				<td>Enter wildcard character (*/?):</td>
				<td><input type="text" name="wildCardChar" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
				<td><input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>