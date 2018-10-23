<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<style>
		h2 {
			color: red;
		}
	</style>
</head>
<body>
	<h1><center>Apply for Leave</center></h1>
	<form:form action="leaveApplied.obj" modelAttribute="employeeLeave">
		<table align="center">
			<tr>
				<td>Employee ID</td>
				<td><form:input path="empId" value="${employeeLeave.empId}" readonly="true"/></td>
			</tr>
			<tr>
				<td>From Date</td>
				<td><form:input type="date" path="fromDate"/>
				<form:errors path="fromDate"></form:errors><td>
			</tr>
			<tr>
				<td>To Date</td>
				<td><form:input type="date" path="toDate"/>
				<form:errors path="toDate"></form:errors><td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form:form>
	<h2><center>TO DATE must be ahead of FROM DATE</center></h2>
</body>
</html>