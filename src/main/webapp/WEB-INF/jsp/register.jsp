<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head lang="en">
    <title>Register</title>
  </head>
  <body>
	<div id="outer">
		<div id="inner">
		<h4>
			<spring:message code="register.registerTitle" />
		</h4>
		
		<spring:url value='/register' var="registerAction"></spring:url>
		<form:form modelAttribute="member" action="${registerAction}" method="post">
			<div class="input-group">
				<spring:message code="username" var="username" />
				<label for="username">${username}</label>
				<div class="errors">
					<form:errors path="userCredentials.username" />
				</div>
				<form:input placeHolder="${username}" id="username" path="userCredentials.username" type="text" />
			</div>

			<div class="input-group">
				<spring:message code="password" var="password" />
				<label for="password">${password}</label>
				<div class="errors">
					<form:errors path="userCredentials.password" />
				</div>
				
				<form:input placeHolder="${password}" id="password" path="userCredentials.password" type="text" />
			</div>

			<div class="input-group">
				<spring:message code="register.verifyPassword" var="verifyPassword" />
				<label for="verifyPassword">${verifyPassword}</label>
				<div class="errors">
					<form:errors path="userCredentials.verifyPassword" />
				</div>
				
				<form:input placeHolder="${verifyPassword}" id="verifyPassword" path="userCredentials.verifyPassword" type="text" />
			</div>

			<div class="input-group">
				<spring:message code="register.email" var="email" />
				<label for="email">${email}</label>
				<div class="errors">
					<form:errors path="email" />
				</div>
				<form:input placeHolder="${email}" id="email" path="email" type="text" />
			</div>			
			<div class="form-group">
			    	<spring:message code="register.registerBtnLabel" var="registerBtnTitle" />
				<input class="formButton" type="submit" value="${registerBtnTitle}">
			</div>

			<div class="form-group">
				<br>
				Already have account? <a href="/login">Login Here</a>
			</div>
		</form:form>
	</div>
	</div>
</body>
</html>