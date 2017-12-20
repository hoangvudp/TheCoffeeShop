<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Members</title>
</head>
<body>
	<table class="zebra">
		<col>
		<col>
		<col>
		<col>
		<thead>
			<tr>
				<th>ID</th>
				<th><spring:message code="members.table.header.username"/></th>
				<th><spring:message code="members.table.header.firstName"/></th>
				<th><spring:message code="members.table.header.lastName"/></th>
				<th><spring:message code="members.table.header.email"/></th>
				<th><spring:message code="members.table.header.phone"/></th>
				<th><spring:message code="members.table.header.city"/></th>
				<th><spring:message code="members.table.header.state"/></th>
				<th><spring:message code="members.table.header.country"/></th>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<th><spring:message code="members.table.header.actions"/></th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.id}</td>
					<td>
						<a href="<spring:url value='/members/${member.id}'/>">${member.userCredentials.username}</a>
					</td>
					<td>${member.firstName}</td>
					<td>${member.lastName}</td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
					<td>${member.address.city}</td>
					<td>${member.address.state}</td>
					<td>${member.address.country}</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					  <td>
						<a href="<spring:url value='/members/edit/${member.id}'/>"><spring:message code="members.table.row.edit"/></a>&nbsp;&nbsp;
						<a href="<spring:url value='/members/delete/${member.id}'/>"><spring:message code="members.table.row.delete"/></a>
					  </td> 
					</security:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
