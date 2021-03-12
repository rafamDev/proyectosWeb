<section id="actions" class="py-4 mb-4 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=regresarAreaCliente" class="btn btn-primary btn-block">
                       Regresar 
                    </a>
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success btn-block">
                       <i class="fas fa-plus"></i> Guardar cliente
                    </button>
                </div>
                <div class="col-md-3">
                  <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&codigo=${cliente.codigo}"
                     class="btn btn-danger btn-block">   
                  <i class="fas fa-trash"></i> Eliminar cliente
                  </a>
                </div>
            </div>    
        </div>
</section>