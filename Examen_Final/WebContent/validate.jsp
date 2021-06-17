<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<title>Gestión Reportes JasperReports | Validar Registro Usuario</title>
</head>
<body>
	<div class="container">
		<c:if test="${error_no_existe == true}">
			<h1>Ese Usuario No esta Registrado</h1>
		</c:if>
		<c:if test="${error_no_existe == false}">
			<c:if test="${cambio_estado == true}">
				<h1>Se ha validado el usuario</h1>
			</c:if>
			<c:if test="${cambio_estado == false}">
				<h1>El ya habia sido validado usuario</h1>
			</c:if>
		</c:if>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>