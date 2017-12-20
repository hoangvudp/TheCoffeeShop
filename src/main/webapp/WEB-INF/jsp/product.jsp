<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row">
  <div class="column left">
    <img src="<c:url value="/images/${product.id}.jpeg"></c:url>" alt="image"  style = "width:100%"/>
  </div>
  <div class="column right">
    <h3>${product.productName}</h3>
	<p>${product.description}</p>
	<p>
		<strong>Category</strong>: ${product.productCategory.name}
	</p>
	<p>
		<strong>Price</strong>: <spring:eval expression= "product.price" /> <spring:message code="currency.type"/></h4>
	</p>
  </div>
</div>
