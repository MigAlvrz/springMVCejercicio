<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>User: ${activeUser.getLogin()}</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <style>
        .card {
            border: 1px solid;
            padding: 10px;
            box-shadow: 5px 10px 18px #888888;
        }
    </style>

</head>

<body>
    <div class="container mt-5 mb-3">
        <div class="row">
            <div class="col">
                <div class="card p-3 mb-2">
                    <div class="d-flex justify-content-between">
                        <div class="d-flex flex-row align-items-center">
                            <div class="icon">
                                <h1 class="display-4 heading ">${activeUser.getLogin()}</h1>
                                <h6 class="text-muted heading">${activeUser.getEmail()}</h6>
                            </div>
                        </div>
                        <div class=""> <span><input type="submit" class="btn btn-outline-secondary btn-sm" value="modificar" data-toggle="modal" data-target="#modalNewUser"></span> </div>
                    </div>
                    <div class="mt-2">
                        <h3 class="heading">Tareas agregadas:<span class="offset-1"> ${tareasTotales}</span></h3>
                        <h3 class="heading">Tareas cumplidas:<span class="offset-1"> ${tareasCumplidas}</span></h3>
                        <h3 class="heading">Tareas pendientes:<span class="offset-1">${tareasPendientes}</span></h3>
                    </div>
                    <div class="mt-4"></div>
                    <form action="/GTD_G2/home/" method="post">
                        <input type="submit" class="btn btn-outline-secondary col-3" value="volver">
                    </form>
                </div>
            </div>
        </div>

    </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalNewUser" tabindex="-1" role="dialog" aria-labelledby="modalNewUser" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modificar usuario</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <form:form method="post" action="newUser" modelAtribute="User">
                    <div class="modal-body">
                        <input type="text" class="form-control" placeholder="Nuevo nombre de usuario" name="username">
                        <input type="email" class="form-control  mt-4" placeholder="Nuevo email" name="email">
                        <input type="email" class="form-control  mt-4" placeholder="Nueva contraseña">
                        <input type="password" class="form-control  mt-4" placeholder="Confirmar nueva contraseña" name="contra">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <input type="submit" value="modificar" class="btn btn-secondary " />
                    </div>
            </div>
            </form:form>
        </div>
    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js " integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo " crossorigin="anonymous "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1 " crossorigin="anonymous "></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js " integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM " crossorigin="anonymous "></script>


</body>

</html>