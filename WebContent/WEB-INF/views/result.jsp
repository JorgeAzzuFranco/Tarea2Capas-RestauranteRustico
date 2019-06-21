<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
		<th>Active?</th>
	</tr>
	<tr>
		<td>${student.sName}</td>
		<td>${student.lName}</td>
		<td>${student.sAge}</td>
		<td>${student.activoDelegate}</td>
	</tr>
</table>
</body>
</html>