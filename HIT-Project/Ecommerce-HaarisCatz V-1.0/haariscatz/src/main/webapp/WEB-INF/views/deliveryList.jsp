<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HaarisCatz Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

</head>
<body>
<h1>HaarisCatz Admin</h1><br>
<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin">HaarisCatz Admin</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/home">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/showOrder">Order List</a>
          </li>

        </ul>

      </div>
    </div>
  </div>
</nav>
<table class="table table-bordered">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.no</th>
      <th scope="col">User Id</th>
      <th scope="col">Invoice Number</th>
      <th scope="col">Net Amount</th>
       <th scope="col">Payment Method</th>
       <th scope="col">Payment ID</th>
       <th scope="col">Bill Date</th>       
      <th scope="col">Proceed</th>
      
    </tr>
  </thead>
  <tbody>
  	<%int i=1; %>
     <c:forEach items="${order}" var="order" >
	    <tr>
	      <th scope="row"><%=i++ %></th>	      
	      <td>${order.cid}</td>
	      <td>${order.invoiceId}</td>
	      <td>${order.netAmount}</td>
	      <td>${order.paymentMethod}</td>
	       <td>${order.paymentId}</td>
	      <td>${order.billDate}</td>
	      <td>
	       <c:choose>  
			<c:when test="${requestScope.check==0}">  
	      <a  href="<c:url value='/delivery-${order.cid}-${order.invoiceId}-done' />"><i class="fas fa-truck"></i></a>	
	      </c:when>  
			<c:otherwise> 
			Completed   
			</c:otherwise>
			</c:choose> 
	      </td>
	      
	      
	    </tr>

     </c:forEach>  
    
  </tbody>
</table>

</body>
</html>