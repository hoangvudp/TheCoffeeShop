<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="navigationBar">
  	<a href="<spring:url value="/welcome"/>"><spring:message code="navigation.home"/></a>&nbsp;&nbsp;
	<a href="<spring:url value="/welcome"/>"><spring:message code="navigation.placeOrder"/></a>&nbsp;&nbsp;
	<a href="<spring:url value="/welcome"/>"><spring:message code="navigation.addProduct"/></a>&nbsp;&nbsp;
</div>
<br>
<br>
<div class="languageBar">
	<a href="?language=en_US">English</a> | <a href="?language=vi_VN">Vietnamese</a>
</div>
<br>
<br>

