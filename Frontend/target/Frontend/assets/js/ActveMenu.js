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

									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" ><button type="button" class="fas fa-shopping-cart fa-2x""></button></a>';

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
	$categoryForm.validate({
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

});
