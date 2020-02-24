<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!--External CSS-->
<link rel="stylesheet" href="./css/style.css">
<title>Create Your Account</title>
</head>
<body>
	<%@ include file="html_fragments/header.jsp"%>
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<form id="createAccountForm">
				<h2>Register</h2>

				<div class="form-group">
					<label for="firstName">First Name</label> <input type="text"
						class="form-control" id="firstName" placeholder="First Name">
				</div>
				<div class="form-group">
					<label for="lastName">Last Name</label> <input type="text"
						class="form-control" id="lastName" placeholder="Last Name">
				</div>
				<div class="form-group">
					<label for="loginEmail">Email address</label> <input type="email"
						class="form-control" id="loginEmail" aria-describedby="emailHelp"
						placeholder="Email">
				</div>
				<div class="form-group">
					<label for="createPassword">Password</label> <input type="password"
						class="form-control" id="createPassword" placeholder="Password">
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password</label> <input
						type="password" class="form-control" id="confirmPassword"
						placeholder="Confirm Password">
				</div>

				<button type="submit" class="btn btn-primary">Register
					Account</button>
				<p>
					Have an account? <a href="./login.jsp">Sign In!</a>
				</p>
			</form>
		</div>
	</div>
	<%@ include file="html_fragments/footer.html"%>

</body>
</html>