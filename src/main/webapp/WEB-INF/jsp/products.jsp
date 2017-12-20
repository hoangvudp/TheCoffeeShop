<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<th><spring:message code="products.table.header.actions"/></th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>
						<a href="<spring:url value='/products/${product.id}'/>">${product.productName}</a>
					</td>
					<td><div class="truncate">${product.description}</div></td>
					<td>${product.productCategory.name}</td>
					<td>${product.price}</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					  <td>
						<a href="<spring:url value='/products/edit/${product.id}'/>"><spring:message code="products.table.row.edit"/></a>&nbsp;&nbsp;
						<a href="<spring:url value='/products/delete/${product.id}'/>"><spring:message code="products.table.row.delete"/></a>
					  </td> 
					</security:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
