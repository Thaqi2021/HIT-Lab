<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
  <h2>SIGN UP TO HAARISCART</h2>
  <p>WE THINK QUALITY .WE INTEGERATE QUALITY.WE THINK FOR CUSTOMER</p>
<form:form action="" modelAttribute="user" method="POST">
   <form:input type="hidden" path="id" id="id"/>

    <div class="row">
      <div class="col">
    <form:input path="email" type="text" class="form-control" id="email" aria-describedby="" placeholder="Enter email"/>
      </div>
      <div class="col">
    <form:input path="password" type="password" class="form-control" id="password" aria-describedby="" placeholder="Enter password"/>
      </div>
    </div>
     <div class="row">
      <div class="col">
    <form:input path="name" type="text" class="form-control" id="name" aria-describedby="" placeholder="Enter Name"/>
      </div>
      <div class="col">
    <form:input path="mobNo" type="number" class="form-control" id="mobNo" aria-describedby="" placeholder="Enter MobileNumber"/>
      </div>
            <div class="col">
    <form:input path="joiningDate" type="text" class="form-control" id="joiningDate" aria-describedby="" placeholder="Enter date"/>
      </div>
    </div>
       <div class="row">
      <div class="col">
    <form:input path="address" type="text" class="form-control" id="address" aria-describedby="" placeholder="Enter Address"/>
      </div>
      <div class="col">
    <form:input path="city" type="text" class="form-control" id="city" aria-describedby="" placeholder="Enter city"/>
      </div>
            <div class="col">
    <form:input path="country" type="text" class="form-control" id="country" aria-describedby="" placeholder="Enter country"/>
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