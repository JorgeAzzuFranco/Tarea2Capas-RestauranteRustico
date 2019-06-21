<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In - Restaurante Rustico</title>
</head>
<body>
	<h1>Students</h1>
		
	<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="usuario">
	
		<form:input type="text" name="usuario" path="usuario"/>
		<form:input type="password" name="clave" path="clave"/>
		<input type="submit" value="Ingresar">
	</form:form>
	
</body>
</html>