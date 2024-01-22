<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="components/allCss.jsp" %>
<style type="text/css">
.back-img {
    background: url("img/kk.jpg");
     width: 100%;
    height: 84vh;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
</head>
<body>
<%@include file="components/navbar.jsp" %>


<div class="container-fluid back-img text-center text-#000000">

<h1> Welcome To Home Page</h1> 
</div>
<%@include file="components/footer.jsp" %>
</body>
</html>