<div id="header">
	<div id="header-title">
		<a href="welcome" class="home-link"> <img
			srcset="images/logo.png 640w, images/logo-small.png 320w"
			sizes="(max-width:640px) 320px, 640px" src="images/logo.png"
			alt="header-image">
			<h4>Your One Stop for Appliances Big and Small</h4>
		</a>
	</div>
	<nav id="header-nav"
		class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#headerNavContent" aria-controls="headerNavContent"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="headerNavContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link dropdown-toggle"
					href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Products </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="products">All</a>
						<c:forEach items="${sessionScope.categories}" var="category">
							<a class="dropdown-item"
								href="products?category=${category.categoryName }">
								${category.categoryName } </a>
						</c:forEach>
					</div></li>

			</ul>
			<ul class="navbar-nav ml-auto">
				<c:if test="${sessionScope.loggedInUser == null}">
					<li><a href="cart"><i
							class="fas fa-shopping-cart fa-lg cart-link"></i></a> <span
						class="badge">${sessionScope.userCartQuantity}</span></li>

					<li class="nav-item"><a class="nav-link" href="./login.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./createAccount.jsp">Register</a></li>
				</c:if>
				<c:if test="${sessionScope.loggedInUser != null}">
					<li class="nav-item"><p class=nav-link>Hello
							${loggedInUser.email}</p></li>
					<li><a href="cart"><i
							class="fas fa-shopping-cart fa-lg cart-link"></i></a><span
						class="badge">${sessionScope.userCartQuantity} </span></li>

					<li class="nav-item"><a class="nav-link" href="LogoutServlet">Log
							Out</a></li>
				</c:if>
			</ul>
		</div>

	</nav>
</div>