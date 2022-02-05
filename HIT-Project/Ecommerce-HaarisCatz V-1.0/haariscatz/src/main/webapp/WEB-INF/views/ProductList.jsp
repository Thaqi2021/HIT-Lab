<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page import="com.haaris.model.Product"%>
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
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin">
      <img src="https://i.ibb.co/YRXB7Sm/H-logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      HaarisCatz Admin
    </a>
  </div>
</nav>
<table class="table table-bordered">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.no</th>
      <th scope="col">product Id</th>
      <th scope="col">product Brand</th>
      <th scope="col">product Name</th>
      <th scope="col">product Qty</th>
      <th scope="col">Edit / Delete</th>
      
    </tr>
  </thead>
  <tbody>
  	<%int i=1; %>
     <c:forEach items="${product}" var="product" >
	    <tr>
	      <th scope="row"><%=i++ %></th>	      
	      <td>${product.product_id}</td>
	      <td>${product.brand}</td>
	      <td>${product.productName}</td>
	      <td>${product.qty}</td>
	      <td><a  href="<c:url value='/edit-${product.product_id}-product' />"><i class='fas fa-edit'> </i>/</a>	      
	      <a  href="<c:url value='/delete-${product.product_id}-product' />"><i class='fas fa-trash-alt'> </i></a>
	      </td>
	      
	      
	    </tr>

     </c:forEach>  
    
  </tbody>
</table>

</body>
</html>