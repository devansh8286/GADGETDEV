$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;

	case 'All Product':
		$('#product').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;

	defaultf: {
		$("#home").addClass("active");
		if (menu == "Home")
			break;

		$('#Product').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

}

var $table = $('#productListTable');

// executing code for table

if ($table.length) {

	// getting json url to give to category

	var jsonUrl = "";
	if (window.categoryId == "") {
		jsonUrl = window.contextRoot + '/json/data/all/products';
	} else {
		jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/products';
	}

	// table structures and all
	$table
			.DataTable({

				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				pageLength : 5,
				// modify the jquery DATATABLE
				ajax : {

					url : jsonUrl,
					dataSrc : ""
				},

				columns : [

						{

							data : 'code',
							mRender : function(data, type, row) {

								return '<img src="' + window.contextRoot
										+ '/Resources/image/' + data
										+ '.jpg" class="dataTableImg"/>';
							}
						},

						{

							data : 'name'
						},
						{

							data : 'brand'
						},
						{

							data : 'unitprice',
							// for rupee sign
							mRender : function(data, type, row) {
								return '&#8377;' + data
							}
						},

						{
							data : 'quantity',

							mRender : function(data, type, row) {
								if (data < 1) {

									return '<span style="color:red">out of Stock</span>';
								}
								return data
							}
						},

						{

							data : 'id',
							mRender : function(data, type, row) {

								var str = '';
								// for view
								str += '<a href="'
										+ window.contextRoot
										+ '/show/'
										+ data
										+ '/product" ><button type="button" class="fas fa-eye fa-2x"></button></a>&#0160';
								// for Cart
								if (row.quantity < 1) {
									str += '<a href=javascript:void(0)"'
											+ window.contextRoot + '/cart/add/'
											+ data + '/product" ></a>';

								} else {

									if (userRole == 'ADMIN') {

										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" ><button type="button" class="fa fa-edit fa-2x""></button></a>';

									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" ><button type="button" class="fa fa-cart-plus fa-2x""></button></a>';
									}
								}

								return str;
							}
						},

				]
			});
}

// dismissing the alert
var $alert = $('.alert');
if ($alert.length) {

	setTimeout(function() {
		$alert.fadeOut('slow');
	}, 3000)

}
// ===================================================

// ===================================================
// data table for Admin

var $adminProductstable = $('#adminProductTable');

// executing code for table

if ($adminProductstable.length) {

	// getting json url to give to category

	var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
	// table structures and all
	$adminProductstable
			.DataTable({

				lengthMenu : [ [ 10, 30, 50, -1 ],
						[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
				pageLength : 30,
				// modify the jquery DATATABLE
				ajax : {

					url : jsonUrl,
					dataSrc : ""
				},

				columns : [
						{

							data : 'id'
						},

						{

							data : 'code',
							mRender : function(data, type, row) {

								return '<img src="' + window.contextRoot
										+ '/Resources/image/' + data
										+ '.jpg" class="adminDataTableImg"/>';
							}
						},

						{

							data : 'name'
						},
						{

							data : 'brand'
						},
						{
							data : 'quantity',

							mRender : function(data, type, row) {
								if (data < 1) {

									return '<span style="color:red">out of Stock</span>';
								}
								return data
							}
						},

						{

							data : 'unitprice',
							// for rupee sign
							mRender : function(data, type, row) {
								return '&#8377;' + data
							}
						},

						{

							data : 'id',

							mRender : function(data, type, row) {
								var str = '';
								str += '<label class="switch">';
								if (data) {
									str += '<input type="checkbox" checked="checked" value="'
											+ row.id + '"/>';
								} else {
									str += '<input type="checkbox"  value="'
											+ row.id + '"/>';
								}
								str += '<div class="slider"></div></lable>'

								return str;

							}
						},
						{
							data : 'id',
							mRender : function(data, type, row) {

								var str = '';
								str += '<a href="' + window.contextRoot
										+ '/manage/' + data + '/product"';
								str += '<button type="button" class="fas fa-edit fa-2x"></button></a>';
								return str;

							}
						}

				],
				initComplete : function() {
					var api = this.api();
					api
							.$('.switch input[type="checkbox"]')
							.on(
									'change',
									function() {
										var checkbox = $(this);
										var checked = checkbox.prop('checked');
										var dMsg = (checked) ? 'you want to active the Product?'
												: 'you want to decactive the Product?';
										var value = checkbox.prop('value');

										bootbox
												.confirm({

													size : 'medium',
													title : 'product Activation & Deactivation',
													message : dMsg,
													callback : function(
															confirmed) {
														if (confirmed) {
															console.log(value);

															var activationUrl = window.contextRoot
																	+ '/manage/product/'
																	+ value
																	+ '/activation';
															$
																	.post(
																			activationUrl,
																			function(
																					data) {

																				bootbox
																						.alert({
																							size : 'medium',
																							title : 'information',
																							message : data

																						});

																			});

														} else {
															checkbox.prop(
																	'checked',
																	!checked);
														}

													}

												});
									});

				}
			})
}

// validation code for Category

var $categoryForm = $('#categoryForm');
if ($categoryForm.length) {
	$categoryForm
			.validate({
				rules : {
					name : {
						required : true,
						minlength : 2
					},
					description : {
						required : true
					}
				},
				messages : {
					name : {
						required : 'please add the name of Category',
						minlength : 'The Length name should not be less than 2 character'
					},
					description : {
						required : 'please add a description for this category!'
					}
				},
				errorElement : 'em',
				errorPlacment : function(error, element) {
					// add the class of help-block
					error.addClass('help-block');
					// add the error element after the input element
					error.insertAfter(element);
				}
			});
}

// product validation end here
/* validating the loginform */

// validating the product form element
// fetch the form element
$loginForm = $('#loginForm');

if ($loginForm.length) {

	$loginForm.validate({
		rules : {
			username : {
				required : true,
				email : true

			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : 'Please enter your email!',
				email : 'Please enter a valid email address!'
			},
			password : {
				required : 'Please enter your password!'
			}
		},
		errorElement : "em",
		errorPlacement : function(error, element) {
			// Add the 'help-block' class to the error element
			error.addClass("help-block");

			// add the error label after the input element
			error.insertAfter(element);
		}
	}

	);

}
// ------------------------------------------------------------------

// for handling CSRF token
var token = $('meta[name="_csrf"]').attr('content');
var header = $('meta[name="_csrf_header"]').attr('content');

if ((token != undefined && header != undefined)
		&& (token.length > 0 && header.length > 0)) {
	// set the token header for the ajax request
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
}
// ------------------------------------------------------------------

// -----handling click event of refresh cart Button-------------------

$('button[name="refreshCart"]')
		.click(
				function() {

					// fetch the cart Line id
					var cartLineId = $(this).attr('value');
					var countElement = $('#count_' + cartLineId);

					var originalCount = countElement.attr('value');
					var currentCount = countElement.val();

					// work only when Count has is changed

					if (currentCount !== originalCount) {

						// console.log("Current count :"+currentCount);
						// console.log("original count :"+originalCount);

						if (currentCount < 1 || currentCount > 5) {

							// reverting back to the original count
							// user has given value below 1 and above 5
							countElement.val(originalCount);
							bootbox
									.alert({

										size : 'medium',
										title : 'check count',
										message : 'product count should be minimum 1 and maximum 5!! '

									});

						} else {

							var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
							
							// forward it to controller

							window.location.href = updateUrl;
							
						
						}

					}

				})

// -------------------end HERE-------------------------------------------

});
