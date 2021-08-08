<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<title>Login</title>
<style>
body {
	background:
		url('https://previews.123rf.com/images/jat306/jat3061702/jat306170200079/71175451-business-concept-of-office-working-business-background.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
}

.card {
	height: 370px;
	margin-top: 20%;
	margin-bottom: auto;
	width: 400px;
}

.input-group-prepend span {
	margin-top: 12px;
	max-height: 35px;
	max-width: 35px;
	width: 50px;
	background-color: lightgray;
	color: black;
	border: 0 !important;
}

input {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-1000">
			<div class="card">
				<div class="card-header">
					<h3>${titulo}</h3>
				</div>
				<div class="card-body">
					<form:form action="login" method="post" modelAtribute="User">
						<div class="input-group-prepend">
							<input type="text" class="form-control" placeholder="usuario"
								name="user">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
								<form action="home" method="post"> 
							</div>
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control" name="contra"
								placeholder="contraseña">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
						</div>
						<input type="submit"
							class="btn btn-outline-secondary btn-lg btn-block" value="entrar">
						<button type="button"
							class="btn btn-outline-secondary btn-lg btn-block"
							data-toggle="modal" data-target="#modalNewUser">nuevo usuario</button>
						</form:form>
				</div>
				<div class="card-footer">
					<p style="color: red;">${ErrorMessage}</p>
				</div>

			</div>

			<!-- Modal -->
			<div class="modal fade" id="modalNewUser" tabindex="-1" role="dialog"
				aria-labelledby="modalNewUser" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Nuevo usuario</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form:form method="post" action="newUser" modelAtribute="User">
							<div class="modal-body">
								<input type="text" class="form-control" placeholder="usuario"
									name="username"> <input type="email"
									class="form-control" placeholder="email" name="email">
								<input type="email" class="form-control"
									placeholder="confirmar email"> <input type="password"
									class="form-control" placeholder="contraseña" name="contra">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Nuevo Usuario"
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