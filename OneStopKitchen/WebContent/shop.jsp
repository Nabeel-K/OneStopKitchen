<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Font Awesome -->
<link rel="stylesheet" href="font-awesome/css/all.css">
<script defer src="font-awesome/js/all.js"></script>
<!--load all styles -->

<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">
<!-- Internal CSS -->
<style>
	span:first-of-type{
		display:block;
	}

</style>
<title>One Stop Kitchen Products</title>
</head>
<body>

	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>

		<div class="body-container container pt-5 mb-5">
			<div class="row mr-0">
				<div class="col-md-12">
					<h2>${categoryName}</h2>
				</div>
				<c:forEach items="${products }" var="product">
					<div class="col-sm-6 col-md-4 col-lg-3 mb-4 item-container">
						<a href="details?product=${product.productName}"> <img
							class="item-block" src="${product.imagePath }"
							alt="${product.productName }">
							<span>${product.productName }</span> <span> <b>Price:
							</b>${product.price }</span> <span> <b>Quantity Left: </b>${product.quantityInStock }</span>
						</a>
					</div>

				</c:forEach>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>

	</div>

</body>
</html>