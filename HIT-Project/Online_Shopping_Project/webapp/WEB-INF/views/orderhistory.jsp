<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <title>HaarisCart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">HaarisCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
      <li><a href="/addProduct">Add Product</a></li>
    </ul>

  </div>
</nav>
<h1>Welcome to HaarisCart Product History World</h1>
<div class="container">
 

<table class="table">
  <thead class ="thead-dark">
    <tr>
      <th scope="col">productId</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
       <th scope="col">Date</th>
      <th scope="col">Order Id</th>
      </tr>
      </thead>
      <tbody>

     <c:forEach items="${wishList}" var="wishList">
    <tr>
    <td>${wishList.productName}</td>
    <td>${wishList.qty}</td>
    <td>${wishList.amount}</td>
  	<td>${wishList.quno}</td>


    
    </tr>
    </c:forEach>
  </tbody>
</table><br>


</div>
</body>
</html>