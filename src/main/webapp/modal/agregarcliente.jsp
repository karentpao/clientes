<!-- Button to Open the Modal --

<!-- The Modal -->
<div class="modal fade" id="agregarCliente">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header bg-info text-white">
         <h5 class="modal-title">Agregar cliente</h5>
           <button class="close" data-dismiss="modal">
           <span>&times;</span>
           </button> 
      </div>
     <div class="modal-body">
       <form action="${pageContext.request.contextPath}/servlet?accion=insertar" method="post" class="was-validated">
       <div class="form-group">
       <label>Nombre</label>
       <input type="text" name="nombre" class="form-control" placeholder="Ingrese nombre" required>
       </div>
       <div class="form-group">
       <label>Apellido</label>
       <input type="text" name="apellido" class="form-control" placeholder="Ingrese apellido" required>
       </div>
       <div class="form-group">
       <label>Email</label>
       <input type="email" name="email" class="form-control" placeholder="Ingrese email" required>
       </div>
       <div class="form-group">
       <label>Teléfono</label>
       <input type="tel" name="telefono" class="form-control" placeholder="Ingrese teléfono" required>
       </div>
       <div class="form-group">
       <label>Saldo</label>
       <input type="number" name="saldo" class="form-control" placeholder="Ingrese saldo" required>
       </div>
     
     </div>
     <div class="modal-footer">
        <input type="submit" name="btn" value="Enviar" class="btn btn-outline-primary">
        
     </div>
     
      </form>
    </div>
  </div>
</div>