<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="floatLeft">
			<a href="<spring:url value="/products/add"/>"><spring:message code="products.addProduct"/></a>
		</div>
	</security:authorize>
	<br>
	<br>
	<table class='tbData'>
		<col>
		<col>
		<col>
		<col>
		<thead>
			<tr>
				<th class='thtdData'>ID</th>
				<th class='thtdData'><spring:message code="products.table.header.name"/></th>
				<th class='thtdData'><spring:message code="products.table.header.description"/></th>
				<th class='thtdData'><spring:message code="products.table.header.category"/></th>
				<th class='thtdData'><spring:message code="products.table.header.price"/></th>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<th class='thtdData'><spring:message code="products.table.header.actions"/></th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr class="dataRowHover">
					<td class='thtdData'>${product.id}</td>
					<td class='thtdData'>
						<a href="<spring:url value='/products/${product.id}'/>">${product.productName}</a>
					</td>
					<td class='thtdData'><div class="truncate">${product.description}</div></td>
					<td class='thtdData'>${product.productCategory.name}</td>
					<td class='thtdData'>${product.price}</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					  <td class='thtdData'>
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
