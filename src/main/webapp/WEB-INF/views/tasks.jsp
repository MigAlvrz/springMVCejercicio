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
				<td>${task.planned}</td>
				<td>${task.comments}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>