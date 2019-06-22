<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Sucursal - Restaurante Rustico</title>
</head>
<body>
	<h1>Editar Sucursal: ${sucursal.nombre}</h1>
	
	<form:form action="${pageContext.request.contextPath}/actualizarSucursal" method="post" modelAttribute="sucursal">
		<input type="hidden" name="codigo" path="codigo" value="${sucursal.codigo}">
		
		<label for="nombre">Nombre de sucursal:</label>
		<input type="text" name="nombre" path="nombre" value="${sucursal.nombre}"/>
		<br>
		<label for="nomGerente">Nombre de gerente:</label>
		<input type="text" name="nomGerente" path="nomGerente" value="${sucursal.nomGerente}"/>
		<br>
		<label for="ubicacion">Ubicaci&oacute;n:</label>
		<input type="text" name="ubicacion" path="ubicacion" value="${sucursal.ubicacion}"/>
		<br>
		<label for="nMesa">Numero de mesas en el local:</label>
		<input type="text" name="nMesa" path="nMesa" value="${sucursal.nMesa}"/>
		<br>
		<label for="horarioInicio">Hora de inicio de actividades:</label>
		<input type="text" name="horarioInicio" path="horarioInicio" value="${sucursal.horarioInicio}"/>
		<br>
		<label for="horarioFin">Hora de fin de actividades:</label>
		<input type="text" name="horarioFin" path="horarioFin" value="${sucursal.horarioFin}"/>
		<br><br>
		<input type="submit" value="Guardar cambios"/>
				
	</form:form>
	
	<h2>Empleados de ${sucursal.nombre}</h2>
	<table>
			<thead>
				<tr>
					<td>Nombre Completo</td>
					<td>Edad</td>
					<td>G&eacute;nero</td>
					<td>Estado</td>
					<td>Acciones</td>
				</tr>
			</thead>
		<c:forEach items="${empleados}" var="empleado">
			<tr>
				<td>${empleado.nombre}</td>
				<td>${empleado.edad}</td>
				<td>${empleado.genero}</td>
				<td>${empleado.estado}</td>
				<td>
					<button onclick="location.href='${pageContext.request.contextPath}/editarEmpleado?codigo=${empleado.codigo}'">Ver Perfil</button>
					<button onclick="location.href='${pageContext.request.contextPath}/borrarEmpleado?codigo=${empleado.codigo}'">Eliminar</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>