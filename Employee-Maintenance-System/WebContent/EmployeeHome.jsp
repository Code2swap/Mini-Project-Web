<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<div>
		<h1>Search Employee</h1>
		<a href = "searchById.obj">Search By Id</a><br>
		<a href = "searchByFirstName.obj">Search By First Name</a><br>
		<a href = "searchByLastName.obj">Search By Last Name</a><br>
		<a href = "searchByDepartment.obj">Search By Department</a><br>
		<a href = "searchByGrade.obj">Search By Grade</a><br>
		<a href = "searchByMaritalStatus.obj">Search By Marital Status</a><br>
	</div>
	<h1>Apply For Leave</h1>
	<a href = "applyLeave.obj?empId=${userDetails.empId}">Apply</a><br>
	<h1>${userDetails.empId}</h1>
</body>
</html>