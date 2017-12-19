<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<table class="zebra">
		<col>
		<col>
		<col>
		<col>
		<thead>
			<tr>
				<th>ID</th>
				<th><spring:message code="products.table.header.name"/></th>
				<th><spring:message code="products.table.header.description"/></th>
				<th><spring:message code="products.table.header.category"/></th>
				<th><spring:message code="products.table.header.price"/></th>
				<th></th> <!-- TODO: check authz -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>
						<a href="<spring:url value='/products/${product.id}'/>">${product.productName}</a>
					</td>
					<td>${product.description}</td>
					<td>${product.productCategory.name}</td>
					<td>${product.price}</td>
					<!-- TODO: check authz -->
					<td>
						<a href="<spring:url value='/products/edit/${product.id}'/>"><spring:message code="products.table.row.edit"/></a>&nbsp;&nbsp;
						<a href="<spring:url value='/products/delete/${product.id}'/>"><spring:message code="products.table.row.delete"/></a>
					</td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<spring:url value="/products/add"/>"><spring:message code="products.addnew"/></a></p>
</body>
</html>
