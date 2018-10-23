<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Employee Home</title>
		<style>
			ul { 
				display:table;
				margin:0 auto;
			}
		</style>
	</head>
	<body>
		<h1><center>Search Employee</center></h1>
		<ul>
			<li><a href = "searchById.obj">Search By Id</a></li>
			<li><a href = "searchByFirstName.obj">Search By First Name</a></li>
			<li><a href = "searchByLastName.obj">Search By Last Name</a></li>
			<li><a href = "searchByDepartment.obj">Search By Department</a></li>
			<li><a href = "searchByGrade.obj">Search By Grade</a></li>
			<li><a href = "searchByMaritalStatus.obj">Search By Marital Status</a></li>
		</ul>
		<h1><center>Apply For Leave</center></h1>
		<center><a href = "applyLeave.obj?empId=${userDetails.empId}">Apply</a></center>
		<h1><center>Manage Leave</center></h1>
		<center><a href = "manageLeave.obj?empId=${userDetails.empId}">Apply</a></center>
	</body>
</html>