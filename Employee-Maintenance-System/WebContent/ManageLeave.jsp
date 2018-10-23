<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	button {
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1><center>List of Leaves to Manage(Status = Applied)</center></h1>
	<c:choose>
		<c:when test="${employeeLeaveList.size()>0}">
			<table border="2" align="center" bgcolor="#EFC8C8">
				<tr>
					<th>Leave ID</th>
					<th>Employee ID</th>
					<th>Applied Date</th>
					<th>Leave Duration</th>
					<th>From Date</th>
					<th>To Date</th>
					<th>Status</th>
					<th colspan="2">ACTION</th>
				</tr>
				<c:forEach items="${employeeLeaveList}" var="leave">
					<tr>
						<td>${leave.leaveId}</td>
						<td>${leave.empId}</td>
						<td>${leave.appliedDate}</td>
						<td>${leave.leaveDuration}</td>
						<td>${leave.fromDate}</td>
						<td>${leave.toDate}</td>
						<td>${leave.status}</td>
						<td><button onclick="location.href='approveLeave.obj?leaveId=${leave.leaveId}'">Approve</button></td>
						<td><button onclick="location.href='rejectLeave.obj?leaveId=${leave.leaveId}'">Reject</button></td>
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