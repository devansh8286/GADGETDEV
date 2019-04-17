<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Header -->
<%@ include file="../shared/flows-header.jsp"%>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<div class="row justify-content-center">
	<div class="col-md-6">
		<div class="card">
			<header class="card-header">
				<a href="" class="float-right btn btn-outline-primary mt-1">Log
					in</a>
				<h4 class="card-title mt-2">Sign up-Address</h4>
			</header>
			<article class="card-body">
				<sf:form method="POST" id="billingForm" modelAttribute="billing">

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Flate or Building</label>
							<sf:input type="text" path="addressLineOne" class="form-control" />
							<sf:errors path="addressLineOne" cssClass="help-block"
								element="em" />
						</div>
						<!-- form-group end.// -->
						<div class="form-group col-md-6">
							<label>Area or Road</label>
							<sf:input class="form-control" path="addressLineTwo" type="text" />
							<sf:errors path="addressLineTwo" cssClass="help-block"
								element="em" />

						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->




					<div class="form-row">
						<div class="col form-group">
							<label>city</label>
							<sf:input type="text" path="city" class="form-control"
								placeholder="" />
							<sf:errors path="city" cssClass="help-block" element="em" />

						</div>
						<!-- form-group end.// -->
					</div>

					<div class="form-row">
						<div class="col form-group">
							<label>postal Code</label>
							<sf:input type="text" path="postalCode" class="form-control"
								placeholder="" />
							<sf:errors path="postalCode" cssClass="help-block" element="em" />

						</div>
						<!-- form-group end.// -->
					</div>


					<div class="form-row">

						<div class="col form-group">
							<label>State</label>
							<sf:input type="text" path="state" class="form-control"
								placeholder=" " />
							<sf:errors path="state" cssClass="help-block" element="em" />

						</div>
						<!-- form-group end.// -->

					</div>
					<!-- form-row.// -->


					<div class="form-group">
						<label>Country</label>
						<sf:input class="form-control" path="country" type="text" />
						<sf:errors path="country" cssClass="help-block" element="em" />
					</div>
					<!-- form-group end.// -->

					<div class="form-group">
						<button type="submit" name="_eventId_confirm"
							class="btn btn-primary btn-block">confirm</button>
						<button type="submit" name="_eventId_personal"
							class="btn btn-primary btn-block">previous</button>

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



<!--container end.//-->

<!-- footeR -->
<%@ include file="../shared/flows-footer.jsp"%>