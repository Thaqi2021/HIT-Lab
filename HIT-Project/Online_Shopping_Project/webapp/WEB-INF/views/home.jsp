<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@page import="com.haariscart.model.Product"%>

      
  
  
    
<!DOCTYPE html>
<html>
<head>
  <title>HaarisCart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 400px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}
</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">HaarisCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
      <li><a href="/addProduct">Add Product</a></li>
      <li><a href="/wishlist"><i class="bi bi-cart"></i>Basket</a></li>
      <li><a href="/order"><i class="bi bi-cart"></i>Orders</a></li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<h1>Welcome to HaarisCart Product World</h1>

<div class="row">
   <c:forEach items="${product}" var="product">
     <div class="column">
		<div class="card">
			<img alt="" src="data:image/jpeg;base64,${product.myImageObj}" style="width:100%">
			<h1>${product.productName}</h1>
			<p class="price">&#x20b9;${product.price} per unit</p>
			<p>${product.pdesc}</p>
			<h3>Available Stock :${product.qty}</h3>
			
			
			 <p><a href="<c:url value='/buy-${product.product_id}-product' />"><button >Add to Cart</button></a></p>
		</div>
	 </div>
	 </c:forEach>  
</div>
</body>
</html>
    