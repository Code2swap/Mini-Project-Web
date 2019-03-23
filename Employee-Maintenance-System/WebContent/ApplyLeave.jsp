<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Apply for Leave</title>
		<link rel="stylesheet" href="css/styles.css">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			$(function() {
				$("#tdate").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				$("#fdate").datepicker({
					dateFormat: 'yy-mm-dd',
					minDate : 0,
					onSelect : function(dateText, inst) {
						var fromDate = $.datepicker.parseDate('yy-mm-dd', dateText);
						//var fromDate = $(this).val();  same as above
						$("#tdate").datepicker("option", "minDate", fromDate);
					}
				});
				
			});
		</script>
	</head>
	<body>
		<h1>Apply for Leave</h1>
		<form:form action="leaveApplied.obj" modelAttribute="employeeLeave">
			<table>
				<tr>
					<td>Employee ID</td>
					<td><form:input path="empId" value="${employeeLeave.empId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>From Date</td>
					<td><form:input type="text" cssClass="date" id="fdate" autocomplete="off" path="fromDate" />
						<form:errors path="fromDate"></form:errors>
					<td>
				</tr>
				<tr>
					<td>To Date</td>
					<td><form:input type="text" cssClass="date" id="tdate" autocomplete="off" path="toDate" />
						<form:errors path="toDate"></form:errors>
					<td>
				</tr>
				<tr>
					<td><input class="inputBtn" type="submit" value="Submit"></td>
					<td><input class="inputBtn" type="reset" value="Clear"></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>