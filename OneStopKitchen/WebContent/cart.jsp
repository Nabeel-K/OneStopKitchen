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

<title>Cart</title>
</head>
<body>
	<%@ include file="html_fragments/header.jsp"%>
	<div class="main-container container-fluid">
		<div class="row mt-4 ml-5 mr-5">
			<div class="col-md-12 mb-5">
				<h2>Your Cart</h2>
			</div>
			<c:if test="${fn:length(sessionScope.userCart.cartItems)>=0}">
				<c:forEach items="${sessionScope.userCart.cartItems}" var="cartItem">
					<div class="col-md-8 offset-1 mt-5 mb-5">
						<img class="item-block" src="images/fridge.png"
							alt="${cartItem.skuNumber }" height="200px">
							<span>${cartItem.skuNumber }</span>
							<p>${cartItem.priceEach }</p>
							<form action="updateCart" method="POST">
								<label for="quantity">Quantity</label>
								<input id="quantity" name="quantity" type="number"
									min="1" value="${cartItem.quantity }">
								<input name="submit" type="submit" value="Update">
							</form>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(sessionScope.userCart.cartItems) == 0}">
				<div class="col-md-12">
					<h5>No items in the cart</h5>
				</div>
			</c:if>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>

</body>
</html>