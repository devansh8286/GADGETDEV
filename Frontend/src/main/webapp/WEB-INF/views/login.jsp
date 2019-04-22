<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/Resources/css" />

<spring:url var="js" value="/Resources/js" />

<spring:url var="img" value="/Resources/image" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<!--Font-Awesomes-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- Latest compiled and minified CSS -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- jquervalidation -->

<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"
	type="text/javascript"></script>
<!-- Popper JS -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>



<!-- Latest compiled JavaScript -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- data table javascript -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<title>GADGETDEV- ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>


<!-- image css -->


<link href="${css }/my.css" rel="stylesheet">

<link href="${css }/toggle.css" rel="stylesheet">
</head>

<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${contextRoot}/home"><strong>GAGETDEV</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>







	<div class="row">


		<div class="container">

			<!-- this will display if user name or password is wrong -->

			<c:if test="${not empty message }">

				<div class="row">
					<div class="col-md-offset-3 col-md-6">

						<div class="alert alert-danger">${message}</div>
					</div>


				</div>
			</c:if>

			<!-- this will display if user Logged out -->

			<c:if test="${not empty logout }">

				<div class="row">
					<div class="col-md-offset-3 col-md-6">

						<div class="alert alert-success"> ${logout}</div>
					</div>


				</div>
			</c:if>



			<div class="row">
				<div class="col-md-offset-3 col-md-6">

					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4>Login</h4>
						</div>

						<div class="panel-body">
							<form action="${contextRoot}/login" method="POST"
								class="form-horizontal" id="loginForm">
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Email:
									</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <input type="submit" value="Login"
											class="btn btn-primary" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footeR -->

		<%@include file="Footer.jsp"%>

		<!-- bootbox -->

		<script src="${js }/bootbox.min.js"></script>


		<!-- self coded     -->
		<script src="${js}/ActveMenu.js"></script>
</body>
</html>
