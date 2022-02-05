<%@page import="com.haaris.model.HaariUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
             <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>HaarisCatz Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">


</head>
<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin">
      <img src="https://i.ibb.co/YRXB7Sm/H-logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      HaarisCatz Admin
    </a>
  </div>
</nav>
<div class="card"style="width: 80rem;  margin: 35px;">
  <div class="card-header">
    User Detail
    
    <a  href="getInvoice-${requestScope.invoiceNo}"><i class="fas fa-print"></i></a>	 
  </div>
  <%
 HaariUser user= (HaariUser) request.getAttribute("user");
  	
  	%>
  <div class="card-body">
    <form:form action="" >
   <input type="hidden" name="id" id="id"/>

    <div class="row">
      <div class="col">
    <input name="name" type="text" class="form-control" value="<%=user.getName() %>" aria-describedby="" disabled>
      </div>
      
       <div class="col">
    <input name="mobNo" type="number" class="form-control" value="<%=user.getMobNo() %>" aria-describedby="" disabled>
      </div>
      <div class="col">
    <input name="email" type="text" class="form-control" value="<%=user.getEmail() %>"  aria-describedby="" disabled>
      </div>
    </div>
    <br>
      <div class="row">
      <div class="col">
          <input name="address" type="text" class="form-control" value="<%=user.getAddress() %>" aria-describedby="" disabled>

      </div>
      </div>
      <br>
     <div class="row">
      <div class="col">
          <input name="city" type="text" class="form-control" value="<%=user.getCity() %>" aria-describedby="" disabled>
      </div>
      <div class="col">
          <input name="country" type="text" class="form-control" value="<%=user.getCountry() %>" aria-describedby="" disabled>
      </div>
    </div>
</form:form>
  </div>
  <table class="table table-bordered" >
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.no</th>
      <th scope="col">product Id</th>
      <th scope="col">product Brand</th>
      <th scope="col">product Name</th>
      <th scope="col">product Qty</th>
      <th scope="col">Price</th>
      
    </tr>
  </thead>
  <tbody>
  	<%int i=1; %>
     <c:forEach items="${list}" var="list" >
	    <tr>
	      <th scope="row"><%=i++ %></th>	      
	      <td>${list.productId}</td>
	      <td>${list.quno}</td>
	      <td>${list.productName}</td>
	      <td>${list.qty}</td>
	      <td>${list.amount}</td>
	      
	      
	    </tr>

     </c:forEach>  
    
  </tbody>
</table>
<br>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
 <c:choose>  
	<c:when test="${requestScope.check!=0}">  
	<a href ="/showOrder"> <button class="btn btn-primary me-md-2" type="button">Back</button></a>
  <a href ="/proceedToDelivery-<%=user.getId() %>-${requestScope.invoiceNo}-ok"><button class="btn btn-success me-md-2" type="button">Proceed</button></a>
 
</c:when>  
	<c:otherwise>
	 <a href ="/displayDeliveryList"> <button class="btn btn-primary me-md-2" type="button">Back</button></a>
  <a href ="/closeOrder-<%=user.getId() %>-${requestScope.invoiceNo}-ok"><button class="btn btn-success me-md-2" type="button">close</button></a>
  	  
  </c:otherwise>  
</c:choose>

</div>
<br>
</div>


</body>
</html>