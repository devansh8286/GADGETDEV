<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<h1 class="my-4">${title}</h1>
<div class="list-group">

<c:forEach items="${categories}" var="category">
	<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name }"> ${category.name}</a>
</c:forEach>
		</div>