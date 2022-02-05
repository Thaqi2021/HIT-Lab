<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@page import="com.haaris.model.Product"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>HaarisCatz</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
<!--image bar-->
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
<!--nav bar-->
body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
<!--search-->
#myUL li a:hover:not(.header) {
  background-color: #eee;
}
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
      <c:choose>  
				<c:when test="${requestScope.userId!=0}">  
     				 <a href="/logout-${requestScope.userId}"><span class="glyphicon glyphicon-log-in"></span> Sign Out</a>
				</c:when>  
				<c:otherwise>  
     				 <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Sign in</a>
				</c:otherwise>  
			</c:choose>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<div id="main">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()"> &#9776; </span>

    <a class="navbar-brand" href="/home">| HaarisCatz</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/home-${requestScope.userId}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/wishlist-${requestScope.userId}">Basket</a>
        </li>
 		 <li class="nav-item">
          <a class="nav-link" href="/order-${requestScope.userId}">Order History</a>
        </li>
      </ul>
      <form class="d-flex" >
        <input class="form-control me-2" type="search" placeholder="Search" id="myInput" aria-label="Search" onkeyup="myFunction()">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<div class="row">
   <c:forEach items="${product}" var="product">
     <div class="column">
		<div class="card" id="myUL">
			<img alt="" src="data:image/jpeg;base64,${product.myImageObj}" style="width:100%">
			<h3>${product.productName} - ${product.brand}</h3>
			<p class="price">&#x20b9;${product.price} per unit<br>
				${product.pdesc}<br>
			Stock :${product.qty}</p>
			
			<c:choose>  
				<c:when test="${product.qty > 0}">  
			 <p><a href="<c:url value='/buy-${product.product_id}-${requestScope.userId}-product' />"><button >Add to Cart</button></a></p>
				</c:when>  
				<c:otherwise>  
			 <p><button disabled>Out Of Stock</button></p>
				</c:otherwise>  
			</c:choose>
		</div>
	 </div>
	 </c:forEach>  
</div>

</div>

<script>
function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>



</body>
</html>