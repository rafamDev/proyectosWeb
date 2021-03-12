<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
         <script src="https://kit.fontawesome.com/f8b76cb4ae.js" crossorigin="anonymous"></script>
         <title>Editar Cliente</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/jspFiles/encabezado.jsp"></jsp:include>
        <form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&codigo=${cliente.codigo}" method="POST">
          <section id="details">
              <div class="container">
                  <div class="row">
                      <div class="col">
                          <div class="card-header">
                              <h4>Editar</h4>
                          </div>
                          <div class="card-body">
                             <div class="form-group">
                             <label for="nombre">Nombre</label>
                             <input type="text" class="form-control" name="nombre" required
                             value="${cliente.nombre}">
                             </div>
                             <div class="form-group">
                             <label for="password">Password</label>
                             <input type="password" class="form-control" name="password" required>
                             </div>
                             <div class="form-group">
                             <label for="apellido">Apellido</label>
                             <input type="text" class="form-control" name="apellido" required
                             value="${cliente.apellido}">
                             </div>
                             <div class="form-group">
                             <label for="email">Email</label>
                             <input type="email" class="form-control" name="email" required
                             value="${cliente.email}">
                             </div>
                             <div class="form-group">
                             <label for="telefono">Telefono</label>
                             <input type="tel" class="form-control" name="telefono" required
                             value="${cliente.telefono}">
                             </div>
                             <div class="form-group">
                             <label for="provincia">provincia</label>
                             <input type="text" class="form-control" name="provincia" required
                             value="${cliente.provincia}">
                             </div>
                             <div class="form-group">
                             <label for="localidad">Localidad</label>
                             <input type="text" class="form-control" name="localidad" required
                             value="${cliente.localidad}">
                             </div>
                             <div class="form-group">
                             <label for="direccion">Direccion</label>
                             <input type="text" class="form-control" name="direccion" required
                             value="${cliente.direccion}">
                           </div>
                         <jsp:include page="/WEB-INF/paginas/jspFiles/botonesNavegacion.jsp"></jsp:include>     
                        </form>
                       </div>
                    </div>
                 </div>
             </div>
          </section>    
       </body> 
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</html>