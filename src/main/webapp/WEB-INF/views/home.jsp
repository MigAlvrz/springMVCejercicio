<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Login</title>
    <style>
        .izquierda {

            min-height: 100vh;
        }

        .derecha {
            background-color: chartreuse;
            min-height: 100vh;
        }

        .opciones {
            background-color: red;
        }
        

        .flex-fill {
          flex:1 1 auto;
        }
    </style>
</head>
<body>
    <div class="container-fluid d-flex">
        <div class="row flex-fill">
            <div class="col-5 h-100 izquierda">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col-1">#</th>
                                <th scope="col-2">tarea</th>
                                <th scope="col-2">fecha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td scope="row">1</td>
                                <td>test</td>
                                <td>1-2-3456</td>     
                            </tr> 
                            <tr>
                                <td scope="row">1</td>
                                <td>test</td>
                                <td>1-2-3456</td>     
                            </tr> 
                            <tr>
                                <td scope="row">1</td>
                                <td>test</td>
                                <td>1-2-3456</td>     
                            </tr> 
                            <tr>
                                <th scope="row">1</th>
                                <td>test</td>
                                <td>1-2-3456</td>     
                            </tr> 
    
                               
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-6 h-100 flex-fill derecha">
    
            </div>
            <div class="col-1  flex-fill opciones">
            <form action="user" method="post">
                <input type="submit" class ="btn btn-outline-secondary" value="usuario">
            </form>
              <form action="admin" method="post">
                <input type="submit" class ="btn btn-outline-secondary" value="admin">
            </form>
            </div>

        </div>
    </div>
</body>
</html>