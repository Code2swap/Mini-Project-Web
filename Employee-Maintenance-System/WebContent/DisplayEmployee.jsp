<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employee Details</title>
</head>
<body>
	<table border="2" align="center" bgcolor="#EFC8C8">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of Birth</th>
			<th>Date of Joining</th>
			<th>Department Name</th>
			<th>Employee Grade</th>
			<th>Designation</th>
			<th>Basic</th>
			<th>Gender</th>
			<th>Marital Status</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Manager Id</th>
			<th>Leave Balance</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>${employee.DOB}</td>
				<td>${employee.DOJ}</td>
				<td>${employee.deptId}</td>
				<td>${employee.grade}</td>
				<td>${employee.designation}</td>
				<td>${employee.basic}</td>
				<td>${employee.gender}</td>
				<td>${employee.marital}</td>
				<td>${employee.address}</td>
				<td>${employee.contact}</td>
				<td>${employee.mgrId}</td>
				<td>${employee.leaveBal}</td>
			</tr>

		</c:forEach>
	</table>
	<a href="AdminHome.jsp">Back to Admin page</a>
	<br>
	<a href="displayLogin.obj">Back to Login page</a>
</body>
</html>