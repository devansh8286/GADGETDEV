
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<c:if test="${not empty messege}">

		<div class="col-xs-12">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>

				${messege}
			</div>
		</div>
	</c:if>


	<div class="row">


		<div class="col-md-offset-2 col-md-8">
			<div class="panel card">

				<div class="card-header">

					<h4>Product Management</h4>

				</div>
				<div class="card-body">
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<!-- modelAttribute linking to manageController -->

						<!--------------------------------------------------------------------------------------------- -->

						<div class="form-group">
							<label class="col-form-label-lg	 col-md-4" for="name">Enter
								Product Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>

						</div>

						<!-- --------------------------------------------------------------------------------------------------------------------------------------- -->

						<div class="form-group">
							<label class="col-form-label-lg col-md-4" for="brand">Enter
								Brand Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<em class="help-bock">please enter Brand </em>
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>

						</div>

						<!-- -------------------------------------------------------------------------------------------------------------------------------------------------- -->

						<div class="form-group">
							<label class="col-form-label-lg col-md-4" for="description">Enter
								description:</label>

							<div class="col-md-8">
								<sf:textarea rows="5" path="description" id="description"
									placeholder="description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>

						</div>

						<!-- --------------------------------------------------------------------------------------------------------------------------------------------- -->


						<div class="form-group">
							<label class="col-form-label-lg col-md-4" for="unitprice">Enter
								Price</label>

							<div class="col-md-8">

								<sf:input type="text" path="unitprice" id="unitprice"
									placeholder="price" class="form-control" />
								<sf:errors path="unitprice" cssClass="help-block" element="em" />
							</div>

						</div>


						<!-- ------------------------------------------------------------------------------------------------------------------------------- -->



						<div class="form-group">
							<label class="col-form-label-lg col-md-4" for="quantity">Enter
								Quantity:</label>

							<div class="col-md-8">

								<sf:input type="text" path="quantity" id="quantity"
									placeholder="quantity" class="form-control" />

							</div>

						</div>
						<!-- ------------------------------------------------------------------------------------------------>

						<!--file upload element -->

						<div class="form-group">
							<label class="col-form-label-lg col-md-4" for="file">Image</label>

							<div class="col-md-8">

								<sf:input type="file" path="file" id="file" class="form-control" />

								<!-- adding validator for image -->

								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>

						</div>



						<!-- ----------------------------------------------------------------------------------------------------------------------- -->

						<div class="form-group">
							<label class="col-form-label-lg col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}"
									itemLabel="name" itemValue="id" class="form-control" />

								<c:if test="${ product.id == 0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal"
											class="btn btn-outline-success">Add Category</button>
									</div>



								</c:if>

							</div>
						</div>

						<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------ -->

						<div class="form-group">

							<div class="col-md-offset col-md-8">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-outline-primary" />


								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />

							</div>

						</div>

						<!-- --------------------------------------------------------------------------------------------------------------------------------- -->

					</sf:form>


				</div>

			</div>

		</div>

	</div>


	<div class="col-xs-12">
		<h3>Available Products</h3>
		<hr />

	</div>

	<div class="col-xs-12">

		<div style="overflow: auto"></div>

		<!-- product table for admin -->
		<table id="adminProductTable"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>&#160;</th>
					<th>Name</th>
					<th>brand</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Active</th>
					<th>Edit</th>
				</tr>
			</thead>
		</table>
		<hr />
	</div>
	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Adding New
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!--category form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
					<div class="form-group">
					<label for="category_name" class="control-label col-md-4">Category Name</label>
					<sf:input type="text" path="name" id="category_name" class="form-control"/>
					</div>
					<div class="form-group">
					<label for="category_description" class="control-label col-md-4">Category Description</label>
					<sf:textarea cols="" rows="5" type="text" path="description" id="category_description" class="form-control"/>
					</div>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<input type="submit" value="ADD Category" class="btn btn-primary">
				</div>
			</div>
			
		</div>
			</sf:form>
	</div>
</div>


