<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/Resources/css" />
<spring:url var="js" value="/Resources/js" />
<spring:url var="img" value="/Resources/image" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- -------------------------------------------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------------------------------------------------------- -->

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<script>
	window.contextRoot = '${contextRoot}';
</script>

<div class="container-fluid">
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<%@include file="sidebar.jsp"%>

			</div>

			<div class="col-md-9">
				<!-- adding breadcrumb -->
				<div class="row">

					<div class="col-lg-12">
						<c:if test="${userClickAllProducts==true}">
							<script>
								window.categoryId = '';
							</script>

							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="${contextRoot }/home">home</a></li>
									<li class="breadcrumb-item active" aria-current="page">AllProduct</li>
								</ol>
							</nav>

						</c:if>
						<c:if test="${userClickCategoryProducts==true}">
							<script>
								window.categoryId = '${category.id}';
							</script>
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="${contextRoot }/home">home</a></li>
									<li class="breadcrumb-item active" aria-current="page">category</li>
									<li class="breadcrumb-item active" aria-current="page">
										${category.name}</li>

								</ol>
							</nav>

						</c:if>
					</div>

						<div class="row">
							<table id="productListTable"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Quantity</th>
										<th></th>

									</tr>


								</thead>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div> 	
</div>

