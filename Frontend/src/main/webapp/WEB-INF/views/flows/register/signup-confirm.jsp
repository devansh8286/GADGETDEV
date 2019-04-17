<!-- Header -->
<%@ include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">
		<div class="card-body">
			<h4 class="card-title">Edit Personal</h4>
			<h6 class="card-subtitle mb-2 text-muted">name:
				${registerModel.user.firstName} ${registerModel.user.lastName}</h6>
			<p class="card-text">email: ${registerModel.user.email} number
				${registerModel.user.contactNumber}</p>
			<h5>role: ${registerModel.user.role}</h5>
			<a href="${flowExecutionUrl }&_eventId_personal" class="card-link">Go
				Back</a>
		</div>


		<div class="card-body">
			<h4 class="card-title">Edit Address</h4>
			<h6 class="card-subtitle mb-2 text-muted">Address:
				${registerModel.billing.addressLineOne} ${registerModel.billing.addressLineTwo}</h6>
			<p class="card-text">city: ${registerModel.billing.city} 
		<h5>country: ${registerModel.billing.country}</h5>
			<h5>postalCode: ${registerModel.billing.postalCode}</h5>
			 state: <h5>country: ${registerModel.billing.state}</h5>
			<a href="${flowExecutionUrl }&_eventId_billing" class="card-link">Go
				Back</a>
		</div>



		<div class="card-body">
			<h4 class="card-title">Confirm</h4>
			<h6 class="card-subtitle mb-2 text-muted"></h6>
			<p class="card-text"></p>
			<a href="${flowExecutionUrl }&_eventId_submit" class="card-link">Confirm
			</a>
		</div>
	</div>
</div>


<%@ include file="../shared/flows-footer.jsp"%>