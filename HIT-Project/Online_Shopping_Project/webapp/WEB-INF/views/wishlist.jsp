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
  <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
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
 	const paymentStart=()=>{
 		console.log("payment started");
 		let amount=$("#payment_field").val();
 		console.log(amount);
		if(amount=="0.0"||amount==null){
	        swal("Sorry!", "Add Product in Basket", "error");
			return;
		}
		$.ajax({
			url:'/wishlist/create_order',
			data:JSON.stringify({amount:amount,info:'order_request'}),
			contentType:'application/json',
			type:'POST',
			dataType:'json',
			success:function(response){
				console.log(response);
				if(response.status=="created"){
					let options = {
						    "key": "rzp_test_T5KTnhikoHhbos",
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
						      //  alert("congrates !payment successfull");
						      	updatePaymentInServer(response.razorpay_payment_id,response.razorpay_order_id,"paid");
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
  function	updatePaymentInServer(payment_id,order_id,status){
  		$.ajax({
			url:'/wishlist/Confirmor',
			data:JSON.stringify({payment_id:payment_id,order_id:order_id,status:status}),
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
      <li><a href="/addProduct">Add Product</a></li>
    </ul>
    
  </div>
</nav>
<h1>Welcome to HaarisCart Product World</h1>
<div class="container">
 

<table class="table">
  <thead class ="thead-dark">
    <tr>
      <th scope="col">product</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
       <th scope="col">Date</th>
      <th scope="col">Edit</th>
      </tr>
      </thead>
      <tbody>

     <c:forEach items="${wishList}" var="wishList">
    <tr>
    <td>${wishList.productName}</td>
    <td>${wishList.qty}</td>
    <td>${wishList.amount}</td>
  	<td>${wishList.date}</td>


    
    </tr>
    </c:forEach>
  </tbody>
</table><br>
<h2>Net Amount :<span class="label label-primary" ><c:out value='${requestScope.netamount}'/></span></h2><br>
		<input type=hidden id="payment_field" value="<c:out value='${requestScope.netamount}'/>">

<button class="btn btn-info" onclick="myFunction()">Confirm Order</button>

<div id="myDIV">
<h1>Choose Payment Method</h1>
    <button class="btn btn-success" onClick=paymentStart()>Online Payment </button>&#9; 
    <a class="btn btn-success" href="<c:url value='/cofirm-${requestScope.userId}-order' />"role="button">Cash On Delivery</a>
</div>

</div>
</body>
</html>
    