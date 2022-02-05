<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@page import="com.haaris.model.Product"%>

      
  
  
    
<!DOCTYPE html>
<html>
<head>
  <title>HaarisCart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
  
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 function myFunction() {
	  var x = document.getElementById("myDIV");
	  if (x.style.display === "none") {
		    x.style.display = "block";
	  } else {
	    x.style.display = "none";


	  }
	}
 	const paymentStart=(id)=>{
 		console.log("payment started");
 		let amount=$("#payment_field").val();
 		console.log(amount);
		if(amount=="0.0"||amount==null){
	        swal("Sorry!", "Add Product in Basket", "error");
			return;
		}
		$.ajax({
			url:'/wishlist/create_order',
			data:JSON.stringify({amount:amount,info:'order_request',id:id}),
			contentType:'application/json',
			type:'POST',
			dataType:'json',
			success:function(response){
				console.log(response);
				if(response.status=="created"){
					let options = {
						    "key": "<<Razor ID>>",
						    "amount": response.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
						    "currency": "INR",
						    "name": "HaarisCart Pvt ltd.",
						    "description": "Test Transaction",
						    "image": "https://i.ibb.co/YRXB7Sm/H-logo.png",
						    "order_id": response.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
						    "handler": function (response){
						        console.log(response.razorpay_payment_id);
						        console.log(response.razorpay_order_id);
						        console.log(response.razorpay_signature);
						        console.log("payment success");
						       alert("congrates !payment successfull");
						      	updatePaymentInServer(response.razorpay_payment_id,response.razorpay_order_id,"paid",id);
						    },
						    "prefill": {
						        "name": "",
						        "email": "",
						        "contact": ""
						    },
						    "notes": {
						        "address": "HaarisCart Pvt Ltd."
						    },
						    "theme": {
						        "color": "#3399cc"
						    }
						};
					var rzp1 = new Razorpay(options);
					rzp1.on('payment.failed', function (response){
					        console.log(response.error.code);
					        console.log(response.error.description);
					        console.log(response.error.source);
					        console.log(response.error.step);
					        console.log(response.error.reason);
					        console.log(response.error.metadata.order_id);
					        console.log(response.error.metadata.payment_id);
					});
				    rzp1.open();

					
				}
			},
			error:function(error){
				console.log(error);
				alert("error");
			}
		})
 	};
  function	updatePaymentInServer(payment_id,order_id,status,id){
  		$.ajax({
			url:'/wishlist/Confirmor',
			data:JSON.stringify({payment_id:payment_id,order_id:order_id,status:status,id:id}),
			contentType:'application/json',
			type:'POST',
			dataType:'json',
			success:function(response){
		        swal("congrates!", "payment successful!", "success");

				},
  			error:function(error){
  		        swal("Failed`!", "We will check & contact you soon", "error");
  			}
			});
  	};

 </script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home">HaarisCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
    </ul>
    
  </div>
</nav>

<div class="container">
 

<table class="table">
  <thead class ="thead-dark">
    <tr>
      <th scope="col">Date</th>
      <th scope="col">product</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Delete</th>
      
      </tr>
      </thead>
      <tbody>

     <c:forEach items="${wishList}" var="wishList">
    <tr>
     <td>${wishList.date}</td>
    <td>${wishList.productName}</td>
    <td>
    <p><a class="btn btn-success" href="/dec-${wishList.productId}-${wishList.cid}" role="button">-</a>
    <span class="label label-default">${wishList.qty}</span>
    <a class="btn btn-success" href="/incre-${wishList.productId}-${wishList.cid}" role="button">+</a></p>
    </td>
    <td>${wishList.amount}</td>
  	<td><a  href="<c:url value='/delete-${wishList.productId}-${requestScope.userId}-list' />"><i class='fas fa-trash-alt' style='font-size:24px'></i></a></td>


    
    </tr>
    </c:forEach>
  </tbody>
</table><br>
<h2 style="">Net Amount :<span class="label label-primary" ><c:out value='${requestScope.netamount}'/></span></h2><br>
		<input type=hidden id="payment_field" value="<c:out value='${requestScope.netamount}'/>">

<div class="container">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">confirm Order</button>
  <a href="<c:url value='/home-${requestScope.userId}'/>"><button type="button"class="btn btn-success btn-lg" >Add More</button></a> 

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
		<h1>Choose Payment Method</h1>
    <button class="btn btn-success" onClick=paymentStart(${requestScope.userId})>Online Payment </button>&#9; 
    <a class="btn btn-success" href="<c:url value='/cofirm-${requestScope.userId}-order' />"role="button">Cash On Delivery</a>        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</div>
</body>
</html>
    
