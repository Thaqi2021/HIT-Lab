<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Note: ${Success}</h1>
    <br/>
    <h3>Go back to <a href="<c:url value='/' />">List of All Workers</a></h3>

</div>
</body>
</html>