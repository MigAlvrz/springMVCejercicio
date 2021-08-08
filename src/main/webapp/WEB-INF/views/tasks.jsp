<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="today" class="java.util.Date" />

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
					<td style = "background-color:red">${task.planned}</td>
				</c:when>
				<c:otherwise>
					<td>${task.planned}</td>
				</c:otherwise>
				</c:choose>
				<td>${task.comments}</td>
			</tr>
		</c:forEach>
	</table>

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
					<td style = "background-color:red">${task.planned}</td>
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
					<td style = "background-color:red">${task.planned}</td>
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
					<td style = "background-color:red">${task.planned}</td>
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