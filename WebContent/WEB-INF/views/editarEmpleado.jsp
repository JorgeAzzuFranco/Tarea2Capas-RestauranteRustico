<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Editar Empleado - Restaurante Rustico</title>
</head>
<body>
	<h1 style="text-align: center;">Editar Empleado: ${empleado.nombre}</h1>
	
	<div class="container" style="margin: auto; padding: 5px; width: 30%; border: solid;border-width: 1px; border-radius: 5px; border-color: gray;">
		<form:form action="${pageContext.request.contextPath}/actualizarEmpleado" method="post" modelAttribute="empleado">
			<input class="form-control" type="hidden" name="codigo" path="codigo" value="${empleado.codigo}">
			
			<label for="nombre">Nombre de empleado:</label>
			<input class="form-control" type="text" name="nombre" path="nombre" value="${empleado.nombre}"/>
			<br>
			<label for="edad">Edad:</label>
			<input class="form-control" type="number" name="edad" path="edad" value="${empleado.edad}"/>
			<br>
			<label for="genero">G&eacute;nero:</label>
			<input class="form-control" type="text" name="genero" path="genero" value="${empleado.genero}"/>
			<br>
			<label for="estado">Estado:</label>
			<div>
				<form:radiobutton name="estado" path="estado" value="True"/>Activo<br>
				<form:radiobutton name="estado" path="estado" value="False"/>Inactivo<br>
			</div>
			<br>
			
			<label for="id_sucursal">Restaurante:</label>
			<form:select class="form-control" name="id_sucursal" path="id_sucursal">
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
			<input class="btn btn-success btn-block" type="submit" value="Guardar cambios"/>	
		</form:form>
	</div>
</body>
</html>