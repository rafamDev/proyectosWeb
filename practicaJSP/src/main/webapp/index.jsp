<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controlador.ServletControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f8b76cb4ae.js" crossorigin="anonymous"></script>
        <title>Logistics S.A</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comunes/encabezado.jsp"></jsp:include>
        <div class="wrapper">
             <form class="form-signin" action="/practicaJSP/ServletControlador" method="post">       
               <h2 class="form-signin-heading">Login</h2>
               <input type="text" class="form-control mt-3" name="nombre" placeholder="nombre" required/>
               <input type="password" class="form-control mt-3" name="password" placeholder="password" required/>      
               <button class="btn btn-lg btn-primary btn-block mt-3 mb-3" type="submit">Login</button> 
             </form>
            <c:if test = "${isUser == false}">
                <script>alert("¡Usuario incorrecto! Debe insertar correctamente el nombre y el password.")</script>
            </c:if>
          </div>    
        <div class="col-md-12 text-center">
            <jsp:include page="WEB-INF/paginas/cliente/agregarCliente.jsp"></jsp:include>       
        </div>
        <jsp:include page="WEB-INF/paginas/comunes/footer.jsp"></jsp:include>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    </body>
</html>
