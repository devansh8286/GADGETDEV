
<script src="https://use.fontawesome.com/c560c025cf.js"></script>

<div class="container">
	<c:choose>
		<c:when test="${not empty cartLine }">



			<div class="card shopping-cart">
				<div class="card-header bg-dark text-light">
					<i class="fa fa-shopping-cart fa-spin" aria-hidden="true"></i>
					${userModel.fullName} cart <a href=""
						class="btn btn-outline-info btn-sm pull-right">Continue
						shopping</a>
					<div class="clearfix"></div>
				</div>
				<div class="card-body">

					<c:forEach items="${cartLine }" var="cartLine">


						<!-- PRODUCT -->
						<div class="row">
							<div class="col-12 col-sm-12 col-md-2 text-center">
								<img class="img-responsive"
									src="${img}/${cartLine.product.code}.jpg"
									alt=" ${cartLine.product.name }" width="140" height="150">
							</div>
							<div
								class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
								<h4 class="product-name">
									<strong> ${cartLine.product.name}</strong>

									<c:if test="${cartLine.available == false }">

										<strong class="unavailable">(Not Available)</strong>
									</c:if>
								</h4>

								<h4>
									<small>Brand - ${cartLine.product.brand} </small>
								</h4>

								<h4>
									<small>Description - ${cartLine.product.description} </small>
								</h4>

							</div>
							<div
								class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
								<div class="col-3 col-sm-3 col-md-6 text-md-right"
									style="padding-top: 5px">
									<h6>
										<strong>&#8377; ${cartLine.buyingPrice} <span
											class="text-muted"> &nbsp; <b>x</b>
										</span></strong>
									</h6>
								</div>
								<div class="col-4 col-sm-4 col-md-4">
									<div class="quantity">
										<input type="number" value="${cartLine.productCount}"
											class="qty">
									</div>
								</div>

								<div class="col-2 col-sm-2 col-md-2 text-right">
									<button type="button" class="btn btn-outline-danger btn-xs">
										<i class="fa fa-trash fa-spin" aria-hidden="true"></i>
									</button>
								</div>


								<div class="pull-right" style="margin: 5px">
									Sub-Total: <b>&#8377; ${cartLine.total} </b>
								</div>


								<div class="col-2 col-sm-2 col-md-2 text-right">
									<button type="button" class="btn btn-outline-info btn-xs">
										<i class="fa fa-refresh fa-spin" aria-hidden="true"></i>
									</button>
								</div>



							</div>
						</div>
						<hr>
						<!-- END PRODUCT -->

					</c:forEach>


					<div class="pull-right">
						<a href="" class="btn btn-outline-secondary pull-right">
							Update shopping Cart </a>
					</div>
				</div>
				<div class="card-footer">
					<div class="pull-right" style="margin: 10px">
						<a href="" class="btn btn-success pull-right">Checkout</a>
						<div class="pull-right" style="margin: 5px">
							Total price: <b>&#8377; ${userModel.cart.grandTotal} </b>
						</div>
					</div>
				</div>
			</div>
</div>
</c:when>

<c:otherwise>

	<div class="jumbotron">
		<div class="text-center">

			<h1>Your cart is empty !</h1>
		</div>

	</div>

</c:otherwise>

</c:choose>
</div>