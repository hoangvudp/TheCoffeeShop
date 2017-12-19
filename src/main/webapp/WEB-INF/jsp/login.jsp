<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<div id="outer">
		<div id="inner">
			<h3>
				<spring:message code="login.pleaseLogin" />
			</h3>
			<c:if test="${not empty error}">
				<div class="errors">
					<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
					<br />
				</div>
			</c:if>
			<form action="<spring:url value="/login"></spring:url>" method="post">
				<div class="form-group">
					<spring:message code="login.username" var="usernamePlaceholder" />
					<input placeholder="${usernamePlaceholder}" name='username' type="text">
				</div>
				<div class="form-group">
					<spring:message code="login.password" var="passwordPlaceholder" />
					<input placeholder="${passwordPlaceholder}" name='password' type="password" value="">
				</div>
				<div class="form-group">
					<spring:message code="login.rememberMe" var="rememberMe" />
			    		<input type='checkbox' name="keepMe"/>${rememberMe}<br/><br>
			    	</div>
			    	<div class="form-group">
			    		<spring:message code="login.loginBtnTitle" var="loginBtnTitle" />
					<input id='btnLogin' type="submit" value="${loginBtnTitle}">
				</div>
				<security:csrfInput />
			</form>
		</div>
	</div>
</body>
</html>