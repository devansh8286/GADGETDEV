<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">home</a></li>
						<li class="breadcrumb-item"><a
							href="${contextRoot}/show/all/products">Products</a></li>
						<li class="breadcrumb-item active" aria-current="page">${product.name}</li>
					</ol>
				</nav>
			</div>
		</div>
		<!-- 	display the product -->
		<div class="container-fluid">

			<div class="row">

				<!-- Display the product image -->
				<div class="col-xs-12 col-sm-4">

					<div class="thumbnail">

						<img src="${img}/${product.code}.jpg"
							class="img img-responsive" />

					</div>

				</div>


				<!-- Display the product description -->
				<div class="col-xs-12 col-sm-8">

					<h3>${product.name}</h3>
					<hr />

					<p>${product.description}</p>
					<hr />

					<h4>
						Price: <strong> &#8377; ${product.unitprice} /-</strong>
					</h4>
					<hr />



					<c:choose>

						<c:when test="${product.quantity < 1}">

							<h6>
								Qty. Available: <span style="color: red">Out of Stock!</span>
							</h6>

						</c:when>
						<c:otherwise>

							<h6>Qty. Available: ${product.quantity}</h6>

						</c:otherwise>

					</c:choose>


					<security:authorize access="hasAuthority('USER')">

						<c:choose>

							<c:when test="${product.quantity < 1}">

								<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
										<span class="fa fa-cart-plus">Add to Cart</span> 
								</strike></a>

							</c:when>
							<c:otherwise>

								<a href="${contextRoot}/cart/add/${product.id}/product"
									class="btn btn-success"> 
									<span class="fa fa-cart-plus">Add to Cart</span>
								</a>




							</c:otherwise>

						</c:choose>
					</security:authorize>


					<security:authorize access="hasAuthority('ADMIN')">
						<a href="${contextRoot}/manage/${product.id}/product"
							class="btn btn-success">
							<span class="fa fa-edit">EDIT</span>
						</a>
					</security:authorize>



					<a href="${contextRoot}/show/all/products" class="btn btn-warning">
						Continue Shopping</a>

				</div>


			</div>

		</div>
	</div>
</div>