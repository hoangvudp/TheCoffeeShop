<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="languageBar">
	Language : <a href="?language=en_US">English</a> | <a href="?language=vi_VN">Vietnamese</a>
</div>

<ul>
  <li><a href="<spring:url value="/welcome"/>">Home</a></li>
	<li><a href="<spring:url value="/welcome"/>">Place Order</a></li>
	<li><a href="<spring:url value="/welcome"/>">Add Product</a></li>
</ul>

