<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${usuario != null}">
	<c:if test="${usuario.rol == 1}">
		<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<title>Role | Roles</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">Inicio</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Tipo Rol <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="role?accion=showInsert">Registrar</a></li>
							<li><a href="role?accion=list">Roles</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<table class="table table-bordered" id="mytable">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descripcion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${list}">
					<tr>
						<td><c:out value="${u.id}"></c:out></td>
						<td><c:out value="${u.description}"></c:out></td>

						<td><a
							href="rol?accion=showEdit&&rol=<c:out value = '${u.id}' />">Editar
						</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="rol?accion=delete&&rol=<c:out value='${u.id}' />">Delete</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
		</html>
	</c:if>
</c:if>
<c:if test="${usuario==null}">
	<%
		response.sendRedirect("login?accion=login");
	%>
</c:if>