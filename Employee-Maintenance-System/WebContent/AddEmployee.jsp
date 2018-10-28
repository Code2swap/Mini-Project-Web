<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Form</title>
</head>
<body>
	<h3><center>Add Employee</center></h3>
	<form:form action="submitEmployee.obj" modelAttribute="employee">
		<table border="2" align="center">
			<tr>
				<td>Employee Id</td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" /></td>

			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>

			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Employee DOB</td>
				<td><form:input type="date" path="DOB" /></td>
				<td><form:errors path="DOB" /></td>
			</tr>
			<tr>
				<td>Employee DOJ</td>
				<td><form:input type="date" path="DOJ" /></td>
				<td><form:errors path="DOJ" /></td>
			</tr>

			<tr>
				<td>Employee Department Name</td>
				<td><form:select path="deptId">
						<form:option value="0" label="-Select-"/>
						<%-- <form:options items="${departmentList}"/> --%>
						
						<c:forEach items="${departmentList}" var="dept">
        					<form:option value="${dept.deptId}" label="${dept.deptName}" />
    					</c:forEach>
						
					</form:select></td>
				<td><form:errors path="deptId" /></td>
			</tr>
			<tr>
				<td>Employee Grade</td>
				<td><form:select path="grade">
						<form:option value="NONE" label="-Select-" />
						<form:options items="${gradeList}" />
					</form:select></td>
				<td><form:errors path="grade" /></td>
			</tr>
			<tr>
				<td>Employee Designation</td>
				<td><form:input path="designation" /></td>
				<td><form:errors path="designation" /></td>
			</tr>
			<tr>
				<td>Employee Basic Salary</td>
				<td><form:input type="number" path="basic" /></td>
				<td><form:errors path="basic" /></td>
			</tr>

			<tr>
				<td>Employee Gender</td>
				<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
						path="gender" value="F" />Female</td>
			</tr>
			<tr>
				<td>Employee Marital Status</td>
				<td><form:select path="marital">
						<form:option value="NONE" label="-Select-"/>
						<form:options items="${maritalList}" />
					</form:select></td>
				<td><form:errors path="marital" /></td>
			</tr>
			<tr>
				<td>Employee Address</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" /></td>
			</tr>
			<tr>
				<td>Employee Contact No.</td>
				<td><form:input path="contact" /></td>
				<td><form:errors path="contact" /></td>
			</tr>
			<tr>
				<td>Employee Manager Id</td>
				<td><form:input path="mgrId" /></td>
				<td><form:errors path="mgrId" /></td>
			</tr>

			<tr>
				<td>Employee Leave Balance</td>
				<td><form:input type="number" path="leaveBal" /></td>
				<td><form:errors path="leaveBal" /></td>
			</tr>

			<tr>
			<tr>
				<td><input type="submit" value="Add Employee"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>