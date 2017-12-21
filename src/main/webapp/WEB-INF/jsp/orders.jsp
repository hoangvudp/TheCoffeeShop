<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<table class='tbData'>
		<col>
		<col>
		<col>
		<col>
		<thead>
			<tr>
			
				<th class='thtdData'><spring:message code="orders.table.header.id"/></th>
				<th class='thtdData'><spring:message code="orders.table.header.date"/></th>
				<th class='thtdData'><spring:message code="orders.table.header.member"/></th>
				<th class='thtdData'><spring:message code="orders.table.header.totalAmount"/></th>
				<th class='thtdData'><spring:message code="orders.table.header.products"/></th> 
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="order">
				<tr class="dataRowHover">
					<td class='thtdData'>${order.id}</td>					
					<td class='thtdData'>${order.orderDate}</td>
					<td class='thtdData'>${order.member.userCredentials.username}</td>
					<c:set var="total" scope="page" value="0.0"/>
					<c:forEach var="orderLine" items="${order.orderLines}">
					    <c:set var="total" scope="page" value="${total + (orderLine.product.price * orderLine.quantity)}" />					  
					</c:forEach>
					
					<td class='thtdData'>${total}</td>
					<td class='thtdData'>
						<ul>
							<c:forEach items="${order.orderLines}" var="orderLine">
								<li> ${orderLine} </li>
							</c:forEach>
						</ul>
						
					</td> 
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
