<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"       uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="es_MX"/>
<section id="clientes">
   <div class="container">
       <div class="row">
         <div class="col-md-9">
            <div class="card">
             <div class="card-header">
              <h4>Listado Clientes</h4>
               </div>
     <table class="table table-sm">
         <thead class="thead-dark">
          <tr>
            <th>#</th>
            <th>Nombre y Apellido</th>
            <th>Email</th>
            <th>Teléfono</th>
            <th>Saldo</th>
            <th></th>
          </tr>
        </thead>
<c:forEach var="c" items="${lis}">
         <tr>
           <td>${c.idcliente}</td>
           <td>${c.nombre} ${c.apellido}</td>
           <td>${c.email}</td>
           <td>${c.telefono}</td>
           <td><fmt:formatNumber value="${c.saldo}" type="currency"/></td>
     <td><a href="servlet?accion=editar&idcliente=${c.idcliente}" class="btn btn-secondary">
           <i class="fas fa-angle-double-right"></i>Editar</a></td>
        </tr>
</c:forEach>
      </table>
          </div>
      </div>
      <div class="col-md-3">
        <div class="card text-center bg-danger text-white mb-3">
          <div class="card-body">
             <h3>Saldo Total</h3>
               <h4 class="display-4">
                 <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                 </h4>
             </div>
           </div>
           
    <div class="card text-center bg-success text-white mb-3">
      
      <div class="card-body">
      <h3>Total Clientes</h3>
      <h4 class="display-4"><i class="fas fa-users"></i>&nbsp; ${totalClientes}</h4>
      </div>
        </div>
        
      
      </div>
    </div>
</div>
</section>

<jsp:include page="modal/agregarcliente.jsp"></jsp:include>
<jsp:include page="modal/editarCliente.jsp"></jsp:include>





