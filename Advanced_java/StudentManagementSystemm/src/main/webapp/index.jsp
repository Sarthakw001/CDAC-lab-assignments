<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
</head>
<body>
	<form action="studentRegister" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td>
				<input name="fn" type="text">
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
				<input name="ln" type="text">
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td>
				<input name="city" type="text">
				</td>
			</tr>
			<tr>
				<td>Course name</td>
				<td>
				<input name="course" type="text">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Register">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>