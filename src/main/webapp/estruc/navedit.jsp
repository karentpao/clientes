<section class="py-4 mb-4 bg-light">
   <div class="container">
     <div class="row">
       <div class="col-md-3">
      <a href="listar.jsp"><i class="fas fa-arrow-left"></i>Regresar al inicio</a>
       </div>
<div class="col-md-3">
      <button type="submit" class="btn btn-success btn-block">
      <i class="fas fa-check"></i>
      Guardar cliente
      </button>
       </div>
    
<div class="col-md-3">
      <a href="${pageContext.request.contextPath}/servlet?accion=eliminar&idcliente=${Cliente.idcliente}" class="btn btn-danger btn-block">
      <i class="fas fa-trash"></i>
      Eliminar cliente</a>
      </button>
       </div>
     </div>
  </div>
   </div>

</section>