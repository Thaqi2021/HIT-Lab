<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
<h1>HaarisCatz Admin</h1><br>
<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin">HaarisCatz Admin</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">HaarisCatz Admin</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/admin">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/showOrder">Order list</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="offcanvasNavbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Product
            </a>
            <ul class="dropdown-menu" aria-labelledby="offcanvasNavbarDropdown">
              <li><a class="dropdown-item" href="/ProductList">Product List</a></li>
              <li><a class="dropdown-item" href="/addProduct">Add Product</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="/showClosedOrder">Closed Order</a></li>
            </ul>
          </li>
        </ul>

      </div>
    </div>
  </div>
</nav>
<div class="card" style=" margin: 35px;">
	<div class="row">
	  <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Add Product</h5>
	        <p class="card-text">HaarisCatz integarate only quality Product.</p>
	        <a href="/addProduct" class="btn btn-primary">Add Product</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Product list</h5>
	        <p class="card-text">We belive in the Customers Statisfaction.</p>
	        <a href="/ProductList" class="btn btn-primary">Product list </a>
	      </div>
	    </div>
	  </div>
	</div>
	<br>
	<div class="row">
	  <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Order List</h5>
	        <p class="card-text">Our Customer .Our belive .our Quality</p>
	        <a href="/showOrder" class="btn btn-primary">Order List</a>
	      </div>
	    </div>
	  </div>
	    <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Delivery List</h5>
	        <p class="card-text">We promisses to delivery On Time .</p>
	        <a href="/displayDeliveryList" class="btn btn-primary">Delivery List</a>
	      </div>
	    </div>
	  </div>
	  </div>
</div>
</body>
</html>