<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Coffee - Order</title>
</head>
<body>
<h3>Place Order </h3>

<form:form modelAttribute="order" action="placeOrder" method="post">
					<fieldset>
						<legend> Order</legend> <br />
						
						<div>
							<form:errors path="*" />
						</div>
						
						<form:label path="orderDate">Order Date</form:label>
						
						<form:input path="orderDate" id="orderDate" />
						<form:errors path="orderDate"></form:errors> <br />
						
						Product Name:
						
						<table class="dynatable">
						 <tbody id="p_scents">
						<tr class="orderline">
						<td>
						<div id="orderLineDiv">
													
						<c:forEach items="${order.orderLines}" var="orderLine" varStatus="idx">
							<form:select path="orderLines[${idx.index}].product.id">
								<form:option value="NULL"	label="--Select	Product--"/>
								<form:options items="${products}" itemLabel="productName" itemValue="id" />
							</form:select>
						
						<form:label path="orderLines[${idx.index}].quantity">Quantity</form:label>
						<form:input path="orderLines[${idx.index}].quantity"/>
						
						</c:forEach>
						
						</div>
						</td>
						<td> <a href="#" id="addScnt">Add</a> </td>
						</tr>										
						
						</tbody>
						</table>
						
						
						<input type="submit" value="Save">
						<input type="button" value="Cancel" />
						
					</fieldset>
				</form:form>

			<div id="test"></div>
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="<spring:url value="/js/order.js"/>"></script>

</body>
</html>

<%-- <form:select path="orderLines[0].product.id">
								<form:option value="NULL"	label="--Select	Product--"/>
								<form:options items="${products}" itemLabel="productName" itemValue="id" />
							</form:select> --%>