
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Header -->
<%@ include file="../shared/flows-header.jsp"%>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header">
					<a href="" class="float-right btn btn-outline-primary mt-1">Log
						in</a>
					<h4 class="card-title mt-2">Sign up</h4>
				</header>
				<article class="card-body">
					<sf:form method="post" id="registerForm" modelAttribute="user">
						<div class="form-row">
							<div class="col form-group">
								<label>First name </label>
								<sf:input type="text" path="firstName" class="form-control"
									placeholder="" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Last name</label>
								<sf:input type="text" path="lastName" class="form-control"
									placeholder=" " />
								<sf:errors path="lastName" cssClass="help-block" element="em" />

							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<label>Email address</label>
							<sf:input type="email" path="email" class="form-control"
								placeholder="" />
							<sf:errors path="email" cssClass="help-block" element="em" />

						</div>
						<!-- form-group end.// -->

						<div class="form-group">
							<label class="form-check form-check-inline"> <sf:radiobutton
									path="role" value="USER" checked="checked" /> <span
								class="form-check-label">User</span>
							</label> <label class="form-check form-check-inline"> <sf:radiobutton
									path="role" value="SUPPLIER" /><span class="form-check-label">Supplier</span>
							</label>
						</div>


						<!-- form-group end.// -->
						<div class="form-group">
							<label>Contact Number</label>
							<sf:input class="form-control" path="contactNumber" type="text" />
							<sf:errors path="contactNumber" cssClass="help-block" element="em" />

						</div>
						<!-- form-group end.// -->

						<div class="form-group">
							<label>Create password</label>
							<sf:input class="form-control" path="password" type="password" />
							<sf:errors path="password" cssClass="help-block" element="em" />

						</div>
						<div class="form-group">
							<label>Confirm password</label>
							<sf:input class="form-control" path="confirmPassword" type="password" />
							<sf:errors path="confirmPassword" cssClass="help-block" element="em" />

						</div>
						
						<!-- form-group end.// -->

						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block"
								name="_eventId_billing">Go For Address</button>


						</div>
						<!-- form-group// -->
					</sf:form>
				</article>
				<!-- card-body end .// -->
				<div class="border-top card-body text-center">
					Have an account? <a href="">Log In</a>
				</div>
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->


</div>
<!--container end.//-->

<!-- footeR -->
<%@ include file="../shared/flows-footer.jsp"%>