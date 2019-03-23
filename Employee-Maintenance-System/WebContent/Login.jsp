<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
		<style>
			td {
				height: 30px;
			}
			.inputBtn {
				width: 90px;
				height: 25px;
				font-weight: bold;
				cursor: pointer;
				/* text-decoration: underline; */
				border: none;
			}
		</style>
	</head>
	<body align="center">
		<h1>Employee Maintenance System</h1>
		<form action="userHome.obj" >
			<table align="center">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="name" />
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pass" />
				</tr>
				<tr>
					<td><input class="inputBtn" type="submit" value="Login"></td>
					<td><input class="inputBtn" type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
		
	</body>
</html>