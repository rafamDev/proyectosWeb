<section id="actions" class="py-4 mb-4 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a href="index.jsp" class="btn btn-primary btn-block"
                       <i class="fas fa-plus"></i> Regresar al inicio
                    </a>
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success btn-block">
                       <i class="fas fa-plus"></i> Guardar cliente
                    </button>
                </div>
                <div class="col-md-3">
                  <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.id_cliente}"
                     class="btn btn-danger btn-block">   
                  <i class="fas fa-trash"></i> Eliminar cliente
                </div>
            </div>    
        </div>
</section>
