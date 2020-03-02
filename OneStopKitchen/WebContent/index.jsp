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

<!-- Internal Styling -->
<style>
#home-products-row {
	padding: 25px;
}

.item-label {
	display: block;
}

span {
	display: block;
}
</style>

<title>One Stop Kitchen</title>
</head>
<body>
	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>


		<div class="row pt-5 mr-0">
			<div class="col-sm-12 col-md-8 col-lg-5 mx-auto">
				<div id="home-carousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#home-carousel" data-slide-to="0" class="active"></li>
						<li data-target="#home-carousel" data-slide-to="1"></li>
					</ol>

					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" src="images/kitchen.jpg"
								alt="washing-machines">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="images/modern-kitchen.jpg"
								alt="washing-machines">
						</div>
					</div>
					<a class="carousel-control-prev" href="#home-carousel"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#home-carousel"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<div class="container body-container mt-4 mb-5">
			<h2>Explore Our Stock</h2>

			<div id="home-products-row" class="row mr-0">

				<c:forEach items="${categories}" var="category">
					<div class="col-md-4 col-lg-3 mb-4 item-container">
						<div class="item-container">
							<a href="products?category=${category.categoryName }"> <img
								class="item-block" src="${category.imagePath }"
								alt="${category.categoryName }"> <span class="item-label">${category.categoryName }</span>
							</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>

	</div>
</body>
</html>