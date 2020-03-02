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
<title>Create Your Account</title>
</head>
<body>

	<div class="main-container container-fluid">
		<%@ include file="html_fragments/header.jsp"%>
		<div class="body-container container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<form id="createAccountForm" class="pb-5 pt-4"
						action="create_account" method="POST">
						<h2>Register</h2>

						<div class="form-group">
							<label for="firstName">First Name</label> <input type="text"
								class="form-control" id="firstName" name="firstName"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<label for="lastName">Last Name</label> <input type="text"
								class="form-control" id="lastName" name="lastName"
								placeholder="Last Name">
						</div>
						<div class="form-group">
							<label for="loginEmail">Email address</label> <input type="email"
								class="form-control" id="loginEmail" name="loginEmail"
								aria-describedby="emailHelp" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="createPassword">Password</label> <input
								type="password" class="form-control" id="createPassword"
								name="createPassword" placeholder="Password">
						</div>
						<div class="form-group">
							<label for="confirmPassword">Confirm Password</label> <input
								type="password" class="form-control" id="confirmPassword"
								name="confirmPassword" placeholder="Confirm Password">
						</div>

						<button type="submit" class="btn btn-primary">Register
							Account</button>
						<p>
							Have an account? <a href="./login.jsp">Sign In!</a>
						</p>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="html_fragments/footer.html"%>
	</div>
</body>
</html>