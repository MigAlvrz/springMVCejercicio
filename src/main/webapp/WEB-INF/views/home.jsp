<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<title>Login</title>
<style>

.edit:hover{
	cursor: pointer;
}

.izquierda {
	min-height: 100vh;
}

.derecha {
	background-color: chartreuse;
	min-height: 100vh;
}

.opciones {
	background-color: #a3b2b8;
}

.opciones p {
	margin-top: 10px;
	font-weight: bold;
}

.opciones input {
	margin-top: 10px;
	font-weight: bolder;
	background-color: whitesmoke;
	color: black;
}

.flex-fill {
	flex: 1 1 auto;
}

.table {
	border: 1px solid;
	padding: 10px;
	box-shadow: 5px 10px 18px #888888;
}
</style>
<script>
	var divs = [ "Menu1", "Menu2", "Menu3", "Menu4" ];
	var visibleDivId = null;
	function toggleVisibility(divId) {
		if (visibleDivId === divId) {
			//visibleDivId = null;
		} else {
			visibleDivId = divId;
		}
		hideNonVisibleDivs();
	}
	function hideNonVisibleDivs() {
		var i, divId, div;
		for (i = 0; i < divs.length; i++) {
			divId = divs[i];
			div = document.getElementById(divId);
			if (visibleDivId === divId) {
				div.style.display = "block";
			} else {
				div.style.display = "none";
			}
		}
	}
</script>
</head>
<body>
	<div class="container-fluid d-flex">
		<div class="row flex-fill">
			<div class="col-11 izquierda">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="col-1"><span class="col-1">tareas!</span> <input
									type="submit" class="btn btn-outline-secondary"
									value="Nueva Tarea" data-toggle="modal"
									data-target="#modalNewTask"> <!-- Js buttons-->
								<th scope="col-1"><span class="col-1"> <a href="#"
										onclick="toggleVisibility('Menu1');">Inbox</a>
								</span></th>
								<th scope="col-1"><span class="col-1"> <a href="#"
										onclick="toggleVisibility('Menu2');">Hoy</a>
								</span></th>
								<th scope="col-1"><span class="col-1"> <a href="#"
										onclick="toggleVisibility('Menu3');">Semana</a>
								</span></th>
								<th scope="col-1"><span class="col-1"> <a href="#"
										onclick="toggleVisibility('Menu4');">Categor�a</a>
								</span></th>
							</tr>
						</thead>
					</table>
					<tbody>

						<div>
							<!-- inbox -->
							<div id="Menu1" style="display: none">
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
											<td class="edit" data-toggle="modal"
									data-target="#modalEditTask${task.id}"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg> </td>
										</tr>
										
										<!-- Modal -->
	<div class="modal fade" id="modalEditTask${task.id}" tabindex="-1" role="dialog"
		aria-labelledby="modalEditTask" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit tarea</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="post" action="editTask" modelAtribute="Task">
					<div class="modal-body">
						<input style="display:none"  type="number" class="form-control" value="${task.id }"
							name="id">
						<input type="text" class="form-control" value="${task.title }"
							name="title">
						<input type="date" class="form-control" value="${task.planned }"
							name="planned">
						<input type="text" class="form-control" value="${task.comments }"
							name="comments">					
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="user" style="display:none" value="${activeUser.getLogin()}">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="contra" style="display:none" value="${activeUser.getPassword()}">
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Nueva Tarea"
							class="btn btn-secondary" />
					</div>
				</form:form>
			</div>
									</c:forEach>
								</table>
							</div>
							<div id="Menu2" style="display: none">
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
											<td class="edit" data-toggle="modal"
									data-target="#modalEditTask${task.id}"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg> </td>
										</tr>
										
										<div class="modal fade" id="modalEditTask${task.id}" tabindex="-1" role="dialog"
		aria-labelledby="modalEditTask" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit tarea</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="post" action="editTask" modelAtribute="Task">
					<div class="modal-body">
						<input style="display:none"  type="number" class="form-control" value="${task.id }"
							name="task">
						<input type="text" class="form-control" value="${task.title }"
							name="task">
						<input type="date" class="form-control" value="${task.planned }"
							name="task">
						<input type="text" class="form-control" value="${task.comments }"
							name="task">					
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="user" style="display:none" value="${activeUser.getLogin()}">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="contra" style="display:none" value="${activeUser.getPassword()}">
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Nueva Tarea"
							class="btn btn-secondary" />
					</div>
				</form:form>
			</div>
									</c:forEach>
								</table>
							</div>
							<div id="Menu3" style="display: none">
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
																	<td class="edit" data-toggle="modal"
									data-target="#modalEditTask${task.id}"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg> </td>
										</tr>
										
										<div class="modal fade" id="modalEditTask${task.id}" tabindex="-1" role="dialog"
		aria-labelledby="modalEditTask${task.id}" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit tarea</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="post" action="editTask" modelAtribute="Task">
					<div class="modal-body">
						<input style="display:none"  type="number" class="form-control" value="${task.id }"
							name="task">
						<input type="text" class="form-control" value="${task.title }"
							name="task">
						<input type="date" class="form-control" value="${task.planned }"
							name="task">
						<input type="text" class="form-control" value="${task.comments }"
							name="task">					
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="user" style="display:none" value="${activeUser.getLogin()}">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="contra" style="display:none" value="${activeUser.getPassword()}">
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Nueva Tarea"
							class="btn btn-secondary" />
					</div>
				</form:form>
			</div>
										
			
									</c:forEach>
								</table>
							</div>
							<div id="Menu4" style="display: none">
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
											
											<td class="edit" data-toggle="modal"
									data-target="#modalEditTask${task.id}"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg> </td>
											
											<div class="modal fade" id="modalEditTask${task.id}" tabindex="-1" role="dialog"
		aria-labelledby="modalEditTask" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Edit tarea</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="post" action="editTask" modelAtribute="Task">
					<div class="modal-body">
						<input style="display:none"  type="number" class="form-control" value="${task.id }"
							name="id">
						<input type="text" class="form-control" value="${task.title }"
							name="title">
						<input type="date" class="form-control" value="${task.planned }"
							name="created">
						<input type="text" class="form-control" value="${task.comments }"
							name="comments">					
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="user" style="display:none" value="${activeUser.getLogin()}">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="contra" style="display:none" value="${activeUser.getPassword()}">
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Nueva Tarea"
							class="btn btn-secondary" />
					</div>
				</form:form>
			</div>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</tbody>
				</div>


			</div>
		</div>
		<div class="col-1  flex-fill opciones">
			<form action="user" method="post">

				<p>${activeUser.getLogin()}</p>


				<input type="submit" class="btn btn-outline-light" value="usuario">
			</form>
			<form action="admin" method="post">
				<input type="submit" class="btn btn-outline-light" value="admin">
			</form>
		</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="modalNewTask" tabindex="-1" role="dialog"
		aria-labelledby="modalNewTask" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nueva tarea</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="post" action="newTask" modelAtribute="Task">
					<div class="modal-body">
						<input type="text" class="form-control" placeholder="Nombre de la tarea"
							name="task">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="user" style="display:none" value="${activeUser.getLogin()}">
						<input  type="text" class="form-control" placeholder="Nombre de la tarea"
							name="contra" style="display:none" value="${activeUser.getPassword()}">
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Nueva Tarea"
							class="btn btn-secondary" />
					</div>
				</form:form>
			</div>



			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
				integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
				integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
				crossorigin="anonymous"></script>
</body>
</html>
</html>