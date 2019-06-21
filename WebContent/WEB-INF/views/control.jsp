<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Centro de control - Restaurante Rustico</title>
</head>
<body>
	<h1>Centro de control de sucursales</h1>
	
	<div>
		<table>
			<thead>
				<tr>
					<td>Nombre de Sucursal</td>
					<td>Direcci&oacute;n</td>
					<td>Horario de apertura</td>
					<td>Horario de cierre</td>
					<td>Acciones</td>
				</tr>
			</thead>
			<c:forEach items="${sucursales}" var="sucursales">
				<tr>
					<td>${sucursales.nombre}</td>
					<td>${sucursales.ubicacion}</td>
					<td>${sucursales.horarioInicio}</td>
					<td>${sucursales.horarioFin}</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>