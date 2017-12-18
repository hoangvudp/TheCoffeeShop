<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
 	<section class="container">
		<table class="zebra"> 
			<col>
			<col>
			<col>
			<col>
			<thead> 
			<tr> 
			    <th>ID</th> 
			    <th>Name</th> 
			    <th>Description</th> 
			    <th>Category</th> 
			    <th>Price</th> 
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
	</section>
</body>
</html>