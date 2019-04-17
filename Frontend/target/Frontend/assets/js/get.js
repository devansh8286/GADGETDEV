	//data table for Admin
	
	var $adminProductstable = $('#adminProductTable');
	
	// executing code for table
	
	if ($adminProductstable.length) {
	
		// getting json url to give to category
	
		var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
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
							
							data:'id'
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
							
								mRender:function(data,type,row){
									var str='';
									str +='<label class="switch">';
									if(data){
										str +='<input type="checkbox" checked="checked" value="'+row.id+'"/>';
								}else{
									str +='<input type="checkbox"  value="'+row.id+'"/>';
								}
							str +='<div class="slider"></div></lable>'
												
												return str;
												
								}
							},
							{
								data:'id',
								mRender:function(data,type,row){
									
									var str='';
									str +='<a href="${contextRoot}/manage/'+data+'/product"';
									str +='<button type="button" class="fas fa-edit fa-2x"></button></a>';
									return str;
								
								}
							}
	
					]
				})
	}
	
	//admin data table done here
	
	//for adding jquery for toggle of admin product v5.7 which is not done yet//
	$('.switch input[type="checkbox"]').on('change',function()
			{
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg=(checked)?'you want to active the Product?':
		                	'you want to decactive the Product?';
		 var value = checkbox.prop('value');
		 
		 bootbox.confirm({
			
			 size:'medium',
			 title:'product Activation & Deactivation',
			 message : dMsg,
			 callback:function(confirmed){
				 if(confirmed){
					 console.log(value);
					 bootbox.alert({
						 size:'medium',
						 title:'information',
						 message:'perfoming operation on Product'+value
					 	});
				 }
				 else{
					 checkbox.prop('checked',!checked);
				 }
				 
			 }
			 
		 });
			});

