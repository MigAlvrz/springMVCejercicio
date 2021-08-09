<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
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
					<h3>Getting tasks done!</h3>
				</div>
				<div class="card-body">
					<div class="input-group-prepend">
						<input type="text" class="form-control" placeholder="usuario">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
							<form action="home" method="post">
						</div>
					</div>
					<div class="input-group form-group">
						<input type="password" class="form-control"
							placeholder="contraseña">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>

					</div>
					<input type="submit"
						class="btn btn-outline-secondary btn-lg btn-block" value="entrar">
					<button type="button"
						class="btn btn-outline-secondary btn-lg btn-block"
						data-toggle="modal" data-target="modalNewUser">nuevo
						usuario</button>
					</form>



				</div>
				<div class="card-footer">

					<div class="modal fade" id="modalNewUser" tabindex="-1"
						role="dialog" aria-labelledby="modalNewUser" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>

						</div>
					</div>
				</div>

			</div>


			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">Launch demo modal</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>test</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
				</div>
			</div>
</body>