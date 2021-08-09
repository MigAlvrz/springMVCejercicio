<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-mdb-toggle="modal"
		data-mdb-target="#exampleModal">Launch demo modal</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">...
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-mdb-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<!-- inbox -->

	<h1>INBOX</h1>
	<table border=1>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>created</th>
			<th>planned</th>
			<th>comments</th>
		</tr>

		<c:forEach items="${tasksInbox}" var="task">
			<tr>
				<td>${task.id}</td>
				<td>${task.title}</td>
				<td>${task.created}</td>
				<c:choose>
					<c:when test="${today.time gt task.planned.time}">
						<td style="background-color: red">${task.planned}</td>
					</c:when>
					<c:otherwise>
						<td>${task.planned}</td>
					</c:otherwise>
				</c:choose>
				<td>${task.comments}</td>
			</tr>
		</c:forEach>
	</table>
	</a>
	<!-- hoy -->
	<h1>HOY</h1>
	<table border=1>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>created</th>
			<th>planned</th>
			<th>comments</th>
		</tr>

		<c:forEach items="${tasksHoy}" var="task">
			<tr>
				<td>${task.id}</td>
				<td>${task.title}</td>
				<td>${task.created}</td>
				<c:choose>
					<c:when test="${today.time gt task.planned.time}">
						<td style="background-color: red">${task.planned}</td>
					</c:when>
					<c:otherwise>
						<td>${task.planned}</td>
					</c:otherwise>
				</c:choose>
				<td>${task.comments}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- semana -->
	<h1>SEMANA</h1>
	<table border=1>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>created</th>
			<th>planned</th>
			<th>comments</th>
		</tr>

		<c:forEach items="${tasksSemana}" var="task">
			<tr>
				<td>${task.id}</td>
				<td>${task.title}</td>
				<td>${task.created}</td>
				<c:choose>
					<c:when test="${today.time gt task.planned.time}">
						<td style="background-color: red">${task.planned}</td>
					</c:when>
					<c:otherwise>
						<td>${task.planned}</td>
					</c:otherwise>
				</c:choose>
				<td>${task.comments}</td>
			</tr>
		</c:forEach>
	</table>


	<!-- Categoria -->
	<h1>Categoria</h1>
	<table border=1>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>created</th>
			<th>planned</th>
			<th>ID categoria</th>
		</tr>

		<c:forEach items="${tasksCategoria}" var="task">
			<tr>
				<td>${task.id}</td>
				<td>${task.title}</td>
				<td>${task.created}</td>
				<c:choose>
					<c:when test="${today.time gt task.planned.time}">
						<td style="background-color: red">${task.planned}</td>
					</c:when>
					<c:otherwise>
						<td>${task.planned}</td>
					</c:otherwise>
				</c:choose>
				<td>${task.categoria}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>