<section id="action" class="py-4 mb-4"> 
<div class="container">
<div class="card p-5">
       <div class="form-group">
       <label>Nombre</label>
       <input type="text" name="nombre" value="${Cliente.nombre}" class="form-control" required>
       </div>
       <div class="form-group">
       <label>Apellido</label>
       <input type="text" name="apellido" value="${Cliente.apellido}" class="form-control" required>
       </div>
       <div class="form-group">
       <label>Email</label>
       <input type="email" name="email" value="${Cliente.email}" class="form-control" required>
       </div>
       <div class="form-group">
       <label>Teléfono</label>
       <input type="tel" name="telefono" value="${Cliente.telefono }" class="form-control"  required>
       </div>
       <div class="form-group">
       <label>Saldo</label>
       <input type="number" name="saldo" value="${Cliente.saldo }" class="form-control" required>
       </div>
   

      </div>
</div>
</section>