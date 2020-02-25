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
<script src="./js/login.js" type="text/javascript"></script>


<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">
<title>Login</title>
</head>
<body>
	<%@ include file="html_fragments/header.jsp"%>
	<div class="main-container container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<form id="loginForm" action="login" method="POST">
					<h2>Login</h2>
					<p class="errorMessage">${errorMessage }</p>
					<div class="form-group">
						<label for="loginEmail">Email address</label> <input type="email"
							class="form-control" id="loginEmail" name="loginEmail"
							aria-describedby="emailHelp" placeholder="Email">
					</div>

					<div class="form-group">
						<label for="loginPassword">Password</label> <input type="password"
							class="form-control" id="loginPassword" name="loginPassword"
							placeholder="Password">
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
					<p>
						Need an account? <a href="./createAccount.jsp">Register Here!</a>
					</p>

				</form>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>
</body>
</html>