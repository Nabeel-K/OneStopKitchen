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
	<div class="main-container">
		<div class="row mt-4">
			<div class="col-md-12">
				<h2>Your Cart</h2>
			</div>
			<c:if test="${fn:length()<=0}"
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>

</body>
</html>