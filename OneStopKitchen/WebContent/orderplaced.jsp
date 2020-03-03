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

<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">

<title>Thank You!</title>
</head>
<body>
	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>

		<div class="body-container container">
			<div class="row pt-4 ml-5 mb-5 mr-5">
				<div class="col-md-12 mb-5">
					<h2>Thank You!</h2>
				</div>
				<div class="col-md-12 mb-5 message-box">
					<p>Your order has been placed. Click the button below to return to the main page.</p>
					<a href="welcome" class="btn btn-primary">Return to Home</a>
				</div>
				
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>

</body>
</html>