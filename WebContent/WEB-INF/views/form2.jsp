<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Usuario</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/formData" modelAttribute="student">
	<form:input type="hidden" name="cStudent" path="cStudent"/>
	<label>Ingrese Nombre: </label>
	<form:input type="text" name="name" path="sName" value="${student.sName}"/>
	<br>
	<label>Ingrese apellido: </label>
	<form:input type="text" name="lname" path="lName" value="${students.lName}"/>
	<br>
	<label>Ingrese edad: </label>
	<form:input type="number" name="age" path="sAge" value="${students.sAge}"/>
	<br>
	<label>Estado del estudiante: </label><br>
	<form:radiobutton name="status" path="bActivo" value="True"/>Activo<br>
	<form:radiobutton name="status" path="bActivo" value="False"/>Inactivo<br>
	
	<input type="submit" value="Actualizar"/>
	</form:form>

</body>
</html>