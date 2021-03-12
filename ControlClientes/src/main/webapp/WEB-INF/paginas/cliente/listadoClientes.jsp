<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
 <section id="clientes">
     <div class="container">
         <div class="row">
             <div class="col-md-9">
                 <div class="card">
                     <div class="card-header">
                         <h4>Listado de clientes</h4>
                     </div>
                     <table class="table table-striped">
                         <thead class="thead-dark">
                               <th>#</th>
                               <th>Nombre</th>
                               <th>Apellido</th>
                               <th>Saldo</th>
                         </thead>
                         <tbody>
                             <c:forEach var="cliente" items="${clientes}" varStatus="status"> 
                                 <tr>
                                     <td>${status.count}</td>
                                     <td>${cliente.nombre}</td>
                                     <td>${cliente.apellido}</td>
                                     <td><fmt:formatNumber value="${cliente.saldo}" type="currency" currencySymbol="&#128"/></td>
                                     <td>
                                         <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.id_cliente}"
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
           <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                     <div class="card-body">
                         <h3>Saldo total</h3>
                         <h4 class="display-4">
                             <i class="las la-users"></i> ${saldoTotal}
                         </h4>
                     </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                     <div class="card-body">
                         <h3>Total clientes</h3>
                         <h4 class="display-4">
                             <i class="las la-users"></i> ${totalClientes}
                         </h4>
                     </div>
                </div>         
            </div>
         </div>
     </div>
     <jsp:include page="agregarCliente.jsp"></jsp:include>                      
 </section>
