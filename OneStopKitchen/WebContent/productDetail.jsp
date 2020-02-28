<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Font Awesome -->
<link rel="stylesheet" href="font-awesome/css/all.css">
  <script defer src="font-awesome/js/all.js"></script> <!--load all styles -->

<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">
<title>${product.productName } Details</title>
</head>
<body>
	<%@ include file="html_fragments/header.jsp"%>
	<div class="main-container container-fluid">
		<div class="row mx-4">
			<div class="col-md-12 mt-3">
				<h2>${product.productName}</h2>
			</div>
			<div class="product-images col-md-6 col-sm-12 mt-3">
				<img class="item-image" src="images/fridge.png"
					alt="${product.productName }" height="200px">
			</div>
			<div class="col-md-6 col-sm-12 mt-3">
				<p><b>Description: </b> ${product.description }</p>
				<p><b>Price: </b>${product.price }</p>
				<p><b>Quantity Left: </b>${product.quantityInStock }</p>
				<form action="cart" method="POST">
					<label for="quantity">Quantity: </label>
					<input type="number" id="quantity" name="quantity" min="1" max="${product.quantityInStock }" value="1">
					<input type="hidden" name="productName" value="${product.productName }">
					<input type="hidden" name="productPrice" value="${product.price }">
					<input type="submit" value="Add to Cart">
				</form>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>

	</div>
</body>
</html>