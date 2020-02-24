<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">
<title>One Stop Kitchen Products</title>
</head>
<body>
	<%@ include file="html_fragments/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h2>${categoryName}</h2>
			</div>
			<c:forEach items="${products }" var="product">
				<div class="col-sm-6 col-md-4 col-lg-3">
					<img class="item-block" src="images/fridge.png"
						alt="${product.productName }" height="200px">
					<p>${product.productName }</p>
					<p>
						<b>Price: </b>${product.price }</p>
					<p>
						<b>Quantity Left: </b>${product.quantityInStock }</p>
				</div>

			</c:forEach>
		</div>
		<%@ include file="html_fragments/footer.html"%>

	</div>

</body>
</html>