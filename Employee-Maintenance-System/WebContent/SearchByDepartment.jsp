<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<form:form method="post" action="searchResultsByDepartment.obj" modelAttribute="departments">
		<form:select multiple="true" path="departmentList">

			<h1>Select Departments Name to search :</h1>

			<select>
				<option disabled selected value>-- select an option --</option>
				<form:options items="${departmentList}" var="department"/>
				<option value="${department.deptName}"></option>
			</select>
		</form:select>
		<input type="submit" value="Search" />

		<input type="reset" value="Clear" />


	</form:form>
</body>
</html>