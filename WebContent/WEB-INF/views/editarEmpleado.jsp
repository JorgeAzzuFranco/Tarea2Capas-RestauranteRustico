<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Empleado - Restaurante Rustico</title>
</head>
<body>
	<h1>Editar Empleado: ${empleado.nombre}</h1>
	
	<form:form action="${pageContext.request.contextPath}/actualizarEmpleado" method="post" modelAttribute="empleado">
		<input type="hidden" name="codigo" path="codigo" value="${empleado.codigo}">
		
		<label for="nombre">Nombre de empleado:</label>
		<input type="text" name="nombre" path="nombre" value="${empleado.nombre}"/>
		<br>
		<label for="edad">Edad:</label>
		<input type="number" name="edad" path="edad" value="${empleado.edad}"/>
		<br>
		<label for="genero">G&eacute;nero:</label>
		<input type="text" name="genero" path="genero" value="${empleado.genero}"/>
		<br>
		<label for="estado">Estado:</label>
		<form:radiobutton name="estado" path="estado" value="True"/>Activo<br>
		<form:radiobutton name="estado" path="estado" value="False"/>Inactivo<br>
		<br>
		
		<label for="id_sucursal">Restaurante:</label>
		<form:select name="id_sucursal" path="id_sucursal">
			<option value="-1">No asignado</option>
			<c:forEach items="${sucursal}" var="sucursal">
				<c:if test="${sucursal.codigo == empleado.id_sucursal }">
					<option value="${sucursal.codigo}" selected>${sucursal.nombre}</option>
				</c:if>
				<c:if test="${sucursal.codigo != empleado.id_sucursal }">
					<option value="${sucursal.codigo}">${sucursal.nombre}</option>
				</c:if>
			</c:forEach>
		</form:select>
		<br><br>
		<input type="submit" value="Guardar cambios"/>
				
	</form:form>
</body>
</html>