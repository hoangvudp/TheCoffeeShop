<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<h1>Product</h1>
	<form:form modelAttribute="product" action="${not empty product.id ? product.id : 'add'}" method="POST">
		<form:errors path="*" cssStyle="color : red;"/> <br>
		
		<label>Name: </label><form:input path="productName"/><br>
		
		<label>Description: </label><form:input path="description"/><br>
		
		<label>Category: </label>
		<form:select path="productCategory.id">
			<form:option value="0"	label="--Select	Category---"/>
			<form:options items="${categories}"	itemLabel="name" itemValue="id"/>
		</form:select>
		<br>
		
		<label>Price: </label><form:input path="price"/><br>
		<form:errors path="price" cssStyle="color:red;"/><br>
		
		<input type="submit" value="Save"/>
	</form:form>
</body>
</html>