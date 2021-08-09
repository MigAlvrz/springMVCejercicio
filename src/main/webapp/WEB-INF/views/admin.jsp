<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Home</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="Col">
				<h1>Users</h1>
				<table class="table">
  					<thead>
    					<tr>
						<th scope="col">Usuario</th>
						<th scope="col">Email</th>
						<th scope="col">Estado</th>
						<th scope="col">Admin</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${Users}">
							<tr>
								<th scope="row">${user.getLogin()}</th>
								<td>${user.getEmail()}</td>
								<td>${user.getStatus()}</td>
								<td>${user.getLogin() ? "si" : "no"}</td>
								<td><input class="btn btn-outline-secondary btn-sm" value="modificar" data-toggle="modal" data-target="#modalNewUser"></td>
							</tr>		
						</c:forEach>
					</tbody>
				</table>	
				 <form action="/GTD_G2/home/" method="post">
					<input type="submit"
						class="btn btn-outline-secondary btn-lg btn-block" value="volver">
				</form>
			</div>
		</div>
	</div>

</body>
</html>