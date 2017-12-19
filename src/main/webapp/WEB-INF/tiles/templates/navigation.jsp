<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="authenticationBar">
	<security:authorize access="isAuthenticated()">
  		<span> Welcome <security:authentication property="principal.username" />!&nbsp;&nbsp;&nbsp;&nbsp;</span>
	</security:authorize>
	<security:authorize access="isAnonymous()">
		<a href="<spring:url value="/login"/>"><spring:message code="navigation.authentication.login" /></a>&nbsp;&nbsp;
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<spring:url value="/logout" var="logout_url" />				
  			<form:form action="${logout_url}" method="POST" id='logoutForm'>
				<a href="#" onclick="document.getElementById('logoutForm').submit(); return false;">
					<spring:message code="navigation.authentication.logout" />
				</a>
		</form:form>
	</security:authorize>
	<security:authorize access="isAnonymous()">
		<a href="<spring:url value="/register"/>"><spring:message code="navigation.authentication.register"/></a>&nbsp;&nbsp;
	</security:authorize>
</div>
<br>
<br>
<div class="navigationBar">
  	<a href="<spring:url value="/"/>"><spring:message code="navigation.home"/></a>&nbsp;&nbsp;
  	<security:authorize access="isAuthenticated()">
		<a href="<spring:url value="/placeOrder"/>"><spring:message code="navigation.placeOrder"/></a>&nbsp;&nbsp;
	</security:authorize>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<a href="<spring:url value="/products/add"/>"><spring:message code="navigation.addProduct"/></a>&nbsp;&nbsp;
	</security:authorize>
</div>
<br>
<br>
