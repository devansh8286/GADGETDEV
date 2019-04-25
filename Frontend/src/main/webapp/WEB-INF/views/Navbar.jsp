<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">

		<a class="navbar-brand" href="${contextRoot}/home"><strong>GAGETDEV</strong></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item " id="home"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item" id="product"><a class="nav-link"
					href="${contextRoot}/show/all/products">Product</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>

				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageProducts"><a class="nav-link"
						href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>

				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="register"><a class="nav-link"
						href="${contextRoot}/register">sign up</a></li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li class="nav-item dropdown" id="userCart"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown"
						href="javascript:void(0)" role="button" aria-haspopup="true"
						aria-expanded="false"> ${userModel.fullName}</a>
						<div class="dropdown-menu">

							<security:authorize access="hasAuthority('USER')">
								<a class="dropdown-item" href="${contextRoot}/cart/show"> <span
									class="fas fa-luggage-cart fa-spin"></span> <span
									class="badge badge-info"> ${userModel.cart.cartLines}</span>
									- &#8377;${userModel.cart.grandTotal}

								</a>
								<div role="separator" class="dropdown-divider"></div>

							</security:authorize>

							<a class="dropdown-item" href="${contextRoot}/perfom-logout">Logout</a>
						</div></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>


<script>
	window.userRole = '${userModel.role}';
</script>