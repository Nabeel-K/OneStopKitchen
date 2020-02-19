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
<title>Login</title>
</head>
<body>
<%@ include file="html_fragments/header.html" %>
	<div class="row">
		<div class="col-md-4 offset-md-4">
		<h2>Login</h2>
			<form id="loginForm">
				<div class="form-group">
					<label for="loginEmail">Email address</label> <input type="email"
						class="form-control" id="loginEmail" aria-describedby="emailHelp"
						placeholder="Email">
				</div>

				<div class="form-group">
					<label for="loginPassword">Password</label> <input type="password"
						class="form-control" id="loginPassword" placeholder="Password">
				</div>

				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
	<%@ include file="html_fragments/footer.html" %>
	
</body>
</html>