<a href="#" class="text-center" data-toggle="modal" data-target="#modalRegistro">Registro</a> <!-- href="#"  data-target="#modalRegistro" id="modalRegistro" -->
<div class="modal fade" id="modalRegistro">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Registro</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
                <form class="was-validated" method="POST">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Password</label>
                            <input type="text" class="form-control" name="password" required>
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
                            <label for="provincia">Provincia</label>
                            <input type="text" class="form-control" name="provincia" required>
                        </div>
                        <div class="form-group">
                            <label for="localidad">Localidad</label>
                            <input type="text" class="form-control" name="localidad" required>
                        </div>
                        <div class="form-group">
                            <label for="direccion">Direccion</label>
                            <input type="text" class="form-control" name="direccion" required>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit">Registro</button>
                        </div>
                </form>
          </div>    
    </div>
</div>

