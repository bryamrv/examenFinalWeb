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
<link href="${pageContext.request.contextPath}/resources/css/"
	rel="stylesheet">

<title>Gestión Reportes JasperReports | Login</title>
</head>
<body>
	<div class="container">
		<form class="row" method="post" action="login?accion=iniciarSesion">
			<div class="form-group">
				<label for="exampleFormControlInput1">Usuario</label> <input
					type="text" class="form-control" id="usuario" name="usuario">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Clave</label> <input
					type="password" class="form-control" id="clave" name="clave"
					placeholder="Clave">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Tipo Persona</label> <select
					class="form-control" id="tipo_persona" name="tipo_persona">
					<c:forEach var="r" items="${roles}" varStatus="loop">
						<option value="${r.id}"><c:out value="${r.description}"></c:out></option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Iniciar Sesión</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>