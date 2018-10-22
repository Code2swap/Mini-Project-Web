<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>Search Results</h1>
	<c:choose>
		<c:when test="${employeeList.size()>0}">
			<table border="2" align="center" bgcolor="#EFC8C8">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DOB</th>
					<th>DOJ</th>
					<th>Dept ID</th>
					<th>Grade</th>
					<th>Designation</th>
					<th>Basic</th>
					<th>Gender</th>
					<th>Marital Status</th>
					<th>Address</th>
					<th>Contact No.</th>
					<th>Managar ID</th>
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
		</c:when>
		<c:otherwise>
			<h3>
				<center>No Data Found</center>
			</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>