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
						Product Name:
						<c:forEach items="${order.orderLines}" var="orderLine" varStatus="idx">
							<form:select path="orderLines[${idx.index}].product.id">
								<form:option value="NULL"	label="--Select	Product--"/>
								<form:options items="${products}" itemLabel="productName" itemValue="id" />
							</form:select>
						</c:forEach>
						<input type="button" value="Add" onclick="make_visible('formInput');return false;">>
						
						 <%-- <form:select path="productCategory.id" id="categories">
							<form:option value="0"	label="--Select	Category--"/>
							<form:options items="${categories}"	itemLabel="name" itemValue="id"/>
						</form:select> --%>
					     
						
						<input type="submit" value="Save">
						
					</fieldset>
				</form:form>

			

</body>
</html>