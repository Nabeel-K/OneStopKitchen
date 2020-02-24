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

<!-- Internal Styling -->
<style>
#home-container {
	padding: 0;
	min-height: 100%;
	position: relative;
}

#home-products-row {
	padding: 25px;
}
</style>

<title>One Stop Kitchen</title>
</head>
<body>
		<%@ include file="html_fragments/header.jsp"%>

	<div id="home-container" class="container-fluid">

		<div class="row mt-5">
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
		<h2>Explore Our Stock</h2>

		<div id="home-products-row" class="row">
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png" alt="Refrigerators"
					height="200px">
				<p>Refrigerators</p>
			</div>
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png" alt="Ovens"
					height="200px">
				<p>Ovens</p>

			</div>
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png" alt="Microwaves"
					height="200px">
				<p>Microwaves</p>

			</div>
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png"
					alt="Small-appliances" height="200px">
				<p>Small Appliances</p>
			</div>
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png" alt="Tools"
					height="200px">
				<p>Tools</p>
			</div>
			<div class="col-md-4 col-lg-3">
				<img class="item-block" src="images/fridge.png" alt="Clearance"
					height="200px">
				<p>Clearance</p>
			</div>

		</div>
		<%@ include file="html_fragments/footer.html"%>

	</div>
</body>
</html>