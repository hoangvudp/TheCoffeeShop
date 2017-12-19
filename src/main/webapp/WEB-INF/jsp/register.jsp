<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head lang="en">
    <title>Register</title>
  </head>
  <body>
	<div class="container">
		<div>Register</div>
		<form:form modelAttribute="member" class="form-horizontal"
			action="/register" method="post">
			<form:errors path="*" cssClass="errors" element="div" />

			<div class="input-group">
				<label for="username"><spring:message
						code="register.username" /></label>
				<form:input id="username" path="userCredentials.username"
					type="text" class="form:input-large" />
				<form:errors path="userCredentials.username" cssClass="errors" />
			</div>

			<div class="input-group">
				<label for="password"><spring:message
						code="register.password" /></label>
				<form:input id="password" path="userCredentials.password"
					type="text" class="form:input-large" />
				<form:errors path="userCredentials.password" cssClass="errors" />
			</div>

			<div class="input-group">
				<label for="username"><spring:message
						code="register.password" /></label>
				<form:input id="email" path="email" type="text"
					class="form:input-large" />
				<form:errors path="email" cssClass="errors" />
			</div>

			<%--               <div class="col-lg-12 form-group" th:classappend="${#fields.hasErrors('passwordConfirm')} ? 'has-error'">
                <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input id="password2" type="password" class="form-control" th:field="*{passwordConfirm}"
                         placeholder="Retype Password" />
                </div>
                <small class="help-block" th:if="${#fields.hasErrors('passwordConfirm')}"
                       th:errors="*{passwordConfirm}"></small>
              </div> --%>

			<div class="form-group">
				<button type="submit">Register</button>
			</div>

			<div class="form-group">
				Already have account? <a href="/login">Login Here</a>
			</div>
		</form:form>
	</div>
</body>
</html>