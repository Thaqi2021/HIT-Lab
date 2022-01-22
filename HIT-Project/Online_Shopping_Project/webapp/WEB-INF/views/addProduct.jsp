<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<div class="container mt-3">
  <h2>REGISTER PRODUCT TO HAARISCART</h2>
  <p>WE THINK QUALITY .WE INTEGERATE QUALITY.WE THINK FOR CUSTOMERS</p>
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
     <div class="row">
      <div class="col">
    <form:input path="qty" type="number" class="form-control" id="qty" aria-describedby="" placeholder="Enter qty"/>
      </div>
      <div class="col">
    <form:input path="price" type="number" class="form-control" id="price" aria-describedby="" placeholder="Enter price"/>
      </div>
    </div>
         <div class="row">
      <div class="col">
          <form:input path="pdesc" type="text" class="form-control" id="pdesc" aria-describedby="" placeholder="Enter Product Desc"/>
      
      </div>
      </div>
       <div class="row">
            <div class="col">
                <input  name="myImage" type="file" class="form-control" id="myImage" aria-describedby="" placeholder="Enter image"/>
            
      </div>
    </div>
     <div class="row">
      <div class="col">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>
      </div>
</form:form>
</div>

</body>
</html>