<button class="btn btn-success" data-toggle="modal" data-target="#agregarClienteModal">editar</button>
<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
                <form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido</label>
                            <input type="text" class="form-control" name="apellido" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono</label>
                            <input type="tel" class="form-control" name="telefono" required>
                        </div>
                        <div class="form-group">
                            <label for="saldo">Saldo</label>
                            <input type="number" class="form-control" name="saldo" step="any" required>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit">Guardar</button>
                        </div>
                </form>
          </div>    
    </div>
</div>
