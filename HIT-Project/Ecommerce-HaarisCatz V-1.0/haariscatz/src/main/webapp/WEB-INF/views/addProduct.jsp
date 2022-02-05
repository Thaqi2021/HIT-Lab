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
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/ProductList">Product List</a>
          </li>
          
        </ul>

      </div>
    </div>
  </div>
</nav>
<br><br>
<center>
<div class="card"style="width: 50rem;  margin: 35px;">
  <div class="card-header">
    Add Product
  </div>
  <div class="card-body">
    <form:form action="" modelAttribute="product" method="POST" enctype = "multipart/form-data">
   <form:input type="hidden" path="product_id" id="product_id"/>

    <div class="row">
      <div class="col">
    <form:input path="hsncode" type="text" class="form-control" id="hsncode" aria-describedby="" placeholder="Enter hsncode"/>
      </div>
      
       <div class="col">
    <form:input path="brand" type="text" class="form-control" id="brand" aria-describedby="" placeholder="Enter brand"/>
      </div>
      <div class="col">
    <form:input path="productName" type="text" class="form-control" id="productName" aria-describedby="" placeholder="Enter ProductName"/>
      </div>
    </div>
    <br>
     <div class="row">
      <div class="col">
    <form:input path="qty" type="number" class="form-control" id="qty" aria-describedby="" placeholder="Enter qty"/>
      </div>
      <div class="col">
    <form:input path="price" type="number" class="form-control" id="price" aria-describedby="" placeholder="Enter price"/>
      </div>
    </div>
    <br>
         <div class="row">
      <div class="col">
          <form:input path="pdesc" type="text" class="form-control" id="pdesc" aria-describedby="" placeholder="Enter Product Desc"/>
      
      </div>
      </div>
      <br>
       <div class="row">
            <div class="col">
                <input  name="myImage" type="file" class="form-control" id="myImage" aria-describedby="" placeholder="Enter image"/>
            
      </div>
    </div>
    <br>
     <div class="row">
      <div class="col">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>
      </div>
</form:form>
  </div>
</div>
</center>
</body>
</html>