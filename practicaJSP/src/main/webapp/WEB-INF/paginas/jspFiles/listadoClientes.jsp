<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
 <section id="clientes">
     <div class="container">
         <div class="row">
             <div class="col-md-10 mt-5">
                 <div class="card">
                     <div class="card-header">
                         <h4>Listado de Clientes</h4>
                     </div>
                     <table class="table table-striped">
                         <thead class="thead-dark">
                               <th>#</th>
                               <th>Nombre</th>
                               <th>Apellido</th>
                               <th>email</th>
                               <th>Telefono</th>
                               <th>Provincia</th>
                               <th>Localidad</th>
                               <th>Direccion</th>
                         </thead>
                         <tbody>
                            <c:forEach var="cliente" items="${clientes}" varStatus="status"> 
                                 <tr>
                                     <td>${status.count}</td>
                                     <td>${cliente.nombre}</td>
                                     <td>${cliente.apellido}</td>
                                     <td>${cliente.email}</td>
                                     <td>${cliente.telefono}</td>
                                     <td>${cliente.provincia}</td>
                                     <td>${cliente.localidad}</td>
                                     <td>${cliente.direccion}</td>
                                     <td>
                                         <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&codigo=${cliente.codigo}"
                                            class="btn btn-primary ml-5">
                                             <i class="fas fa-angle-double-right"></i>Editar
                                         </a>    
                                     </td>
                                 </tr>  
                            </c:forEach>
                         </tbody>
                     </table>
                 </div>
             </div>
           <div class="col-md-2 mt-5">
                <div class="card text-center bg-info text-white mb-3">
                     <div class="card-body">
                         <h3>Total clientes</h3>
                         <h4 class="display-2">
                             <i class="las la-users"></i> ${totalClientes}
                         </h4>
                     </div>
                </div>
                      
            </div>
         </div>
     </div>
</section>