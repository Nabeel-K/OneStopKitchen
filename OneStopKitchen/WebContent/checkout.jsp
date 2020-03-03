<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<!-- Internal CSS-->
<style>
table {
	width: 100%;
}

tr, th, td {
	border: 1px solid black;
}

span {
	display: block;
}
</style>

<title>Checkout</title>
</head>
<body>
	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>

		<div class="body-container container pb-5">
			<div class="row pt-4 ml-5 mr-5">
				<div class="col-md-12 mb-5">
					<h2>Checkout</h2>
				</div>

				<div class="col-md-12">
					<h4>
						SubTotal:<span>$<fmt:formatNumber type="number"
								minFractionDigits="2" maxFractionDigits="2"
								value="${cartTotal }" /></span>
					</h4>
				</div>
				<div class="col-md-12">
					<table>
						<tr>
							<th>Item</th>
							<th>Price Each</th>
							<th>Quantity Ordered</th>
						</tr>
						<c:forEach items="${sessionScope.userCart.cartItems}"
							var="cartItem">
							<tr>
								<td><img class="item-block" src="images/fridge.png"
									alt="${cartItem.skuNumber }" height="200px"> <span>${cartItem.skuNumber }</span>
								</td>
								<td><p>
										$
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${cartItem.priceEach }" />
									</p></td>
								<td><p>${cartItem.quantity}</p></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="row pt-4 ml-5 mr-5 pb-5">
				<div class="col-md-12 mb-5">
					<h2>Shipping and Billing information</h2>
				</div>
				
				<form action="purchase" method="POST">
					<div class="row">
						<div class="col-lg-6 col-md-12">
							<div class="form-group">
								<label for="billingAddress">Address</label> <input required
									type="text" class="form-control" id="billingAddress"
									name="billingAddress"
									placeholder="${sessionScope.loggedInUser.address}">
							</div>

							<div class="form-group">
								<label for="billingCity">City</label> <input required
									type="text" class="form-control" id="billingCity"
									name="billingCity"
									placeholder="${sessionScope.loggedInUser.city}">
							</div>

							<div class="form-group">
								<label for="billingZipcode">Zipcode</label> <input required
									type="text" class="form-control" id="billingZipcode"
									name="billingZipcode"
									placeholder="${sessionScope.loggedInUser.city}">
							</div>

							<div class="form-group">
								<label for="billingState">State</label> <input required
									type="text" class="form-control" id="billingState"
									name="billingState"
									placeholder="${sessionScope.loggedInUser.state}">
							</div>
						</div>
						<div class="col-lg-6 col-md-12">
							<div class="form-group">
								<label for="country">Country</label>
								<%@ include file="html_fragments/ISOCountryCodesAlpha3.html"%>
							</div>

							<div class="form-group">
								<label for="creditcardNumber">Credit Card Number</label> <input
									required type="text" class="form-control" id="creditcardNumber"
									name="creditcardNumber">
							</div>
							<div class="form-group">
								<label for="cvv">CVV</label> <input required type="text"
									class="form-control" id="cvv" name="cvv">
							</div>
							<div class="form-group">
								<label for="nameOnCard">Name On Card</label> <input required
									type="text" class="form-control" id="nameOnCard"
									name="nameOnCard">
							</div>
							<button type="submit" class="btn btn-primary">Submit
								Order</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>

</body>
</html>