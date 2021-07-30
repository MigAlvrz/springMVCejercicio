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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

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
				<form:form>
						</div>
					</div>
					<div class="input-group form-group">
						<input type="password" class="form-control"
							placeholder="contraseña">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>

					</div>
					<button type="button"
						class="btn btn-outline-secondary btn-lg btn-block">enviar</button>
					<button type="button"
						class="btn btn-outline-secondary btn-lg btn-block">nuevo
						usuario</button>
				</form:form>
				


				</div>
				<div class="card-footer"></div>
			</div>
		</div>

	</div>
</body>