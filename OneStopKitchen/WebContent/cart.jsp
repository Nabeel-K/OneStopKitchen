<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="html_fragments/taglibs.jsp" %>

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
	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>

		<div class="body-container container">
			<div class="row pt-4 ml-5 mb-5 mr-5">
				<div class="col-md-12 mb-5">
					<h2>Your Cart</h2>
				</div>
				<c:if test="${fn:length(sessionScope.userCart.cartItems)>0}">
					<div class="col-md-12">
						<h4>
							SubTotal:<span> $ <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cartTotal }"/></span>
						</h4>
						<a href="checkout?cartTotal=${cartTotal }"
							class="btn btn-primary">Checkout</a> <a href="products"
							class="btn btn-outline-primary">Continue Shopping</a>

					</div>
					<c:forEach items="${sessionScope.userCart.cartItems}"
						var="cartItem">
						<div class="col-md-8 offset-1 mt-5 mb-5">
							<img class="item-block" src="images/fridge.png"
								alt="${cartItem.skuNumber }" height="200px"> <span>${cartItem.skuNumber }</span>
							$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cartItem.priceEach }"/>
							<form action="updatecart?cartItem=${cartItem.skuNumber }"
								method="POST">
								<div class=form-group>
									<label for="quantity">Quantity</label> <input
										class="form-control" id="quantity" name="quantity"
										type="number" min="1" value="${cartItem.quantity }">
									<button type="submit" class="btn btn-primary">Update</button>
								</div>
								<a href="deleteitem?cartItem=${cartItem.skuNumber }"
									class="btn btn-outline-primary">Remove from Cart</a>
							</form>


						</div>
					</c:forEach>
				</c:if>
				<c:if test="${fn:length(sessionScope.userCart.cartItems) == 0}">
					<div class="col-md-12">
						<h5>No items in the cart</h5>
						<a href="products" class="btn btn-outline-primary">Continue
							Shopping</a>
					</div>
				</c:if>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>

</body>
</html>