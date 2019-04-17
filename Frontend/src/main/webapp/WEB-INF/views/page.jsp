<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/Resources/css" />

<spring:url var="js" value="/Resources/js" />

<spring:url var="img" value="/Resources/image" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>

<head>
<!--Font-Awesomes-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- Latest compiled and minified CSS -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- jquervalidation -->

<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js" type="text/javascript"></script>
<!-- Popper JS -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>



<!-- Latest compiled JavaScript -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- data table javascript -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<title>GADGETDEV- ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>


<!-- image css -->


<link href="${css }/my.css" rel="stylesheet">

<link href="${css }/toggle.css" rel="stylesheet">
</head>

<body>
	<!-- HeAder -->

	<%@include file="Navbar.jsp"%>




	<!-- page content -->
	<c:if test="${userClickHome == true }">
		<%@include file="home.jsp"%>
	</c:if>


	<!-- userclickabout -->
	<c:if test="${userClickAbout == true }">
		<%@include file="about.jsp"%>
	</c:if>


	<!-- userclickContact -->
	<c:if test="${userClickContact == true }">
		<%@include file="contact.jsp"%>
	</c:if>

	<!-- userclickallProduct or CATEGORY product -->

	<c:if
		test="${userClickAllProducts==true or userClickCategoryProducts==true}">
		<%@include file="listProduct.jsp"%>
	</c:if>

	<!-- only load when user click show Product -->

	<c:if test="${userClickShowProduct==true}">
		<%@include file="singleProductDisplay.jsp"%>
	</c:if>

	<!-- user Click MANAGE PRODUCT -->

	<c:if test="${userClickManageProducts==true}">
		<%@include file="manageProduct.jsp"%>
	</c:if>


	<!-- footeR -->

	<%@include file="Footer.jsp"%>

	<!-- bootbox -->

	<script src="${js }/bootbox.min.js"></script>

	
	<!-- self coded     -->
	<script src="${js}/ActveMenu.js"></script>

</body>
</html>
