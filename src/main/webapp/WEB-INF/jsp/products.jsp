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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.description}</td>
					<td>${product.productType}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
