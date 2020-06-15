<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<!-- cebecero -->
<jsp:include page="estruc/cabecero.jsp"/>
<!-- barra de navegación -->
<jsp:include page="estruc/nav.jsp"></jsp:include>
<c:if test="${msj > 0}">
<div class="alert alert-success  alert-dismissible">
<button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>${msj}</strong>
</div>

</c:if>
<!-- tabla de clientes -->
<jsp:include page="tablaCli.jsp"/>
<!-- pie de pagina -->
<jsp:include page="estruc/footer.jsp"></jsp:include>

<script src="https://kit.fontawesome.com/c2d9db48fd.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
