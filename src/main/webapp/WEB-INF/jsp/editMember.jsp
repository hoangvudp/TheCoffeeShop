<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<script type="text/javascript" src="<spring:url value="/js/ajax.js"/>"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<form:form modelAttribute="member"
	action="${not empty member.id ? member.id : 'add'}" method="POST"
	enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="3"><form:errors path="*" cssStyle="color : red;" /></td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td colspan="2"><form:input path="userCredentials.username"
					readonly="true" cssStyle="width:100em'" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td colspan="2"><form:input path="firstName"
					cssStyle="width:100em'" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td colspan="2"><form:input path="lastName"
					cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td colspan="2"><form:input path="email" cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td colspan="2"><form:input path="phone" cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td colspan="2"><form:input path="address.city"
					cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td colspan="2"><form:input path="address.state"
					cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td colspan="2"><form:input path="address.country"
					cssStyle="width:20em'" /></td>
		</tr>
		<tr>
			<%-- <form:input path="userCredentials.password" type="hidden"
					cssStyle="width:20em'" /> --%>
			<td colspan="3"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>