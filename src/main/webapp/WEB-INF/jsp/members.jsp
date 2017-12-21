<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Members</title>
</head>
<body>
	<table class='tbData'>
		<col>
		<col>
		<col>
		<col>
		<thead>
			<tr>
				<th class='thtdData'>ID</th>
				<th class='thtdData'><spring:message code="members.table.header.username"/></th>
				<th class='thtdData'><spring:message code="members.table.header.firstName"/></th>
				<th class='thtdData'><spring:message code="members.table.header.lastName"/></th>
				<th class='thtdData'><spring:message code="members.table.header.email"/></th>
				<th class='thtdData'><spring:message code="members.table.header.phone"/></th>
				<th class='thtdData'><spring:message code="members.table.header.address"/></th>
				<th class='thtdData'><spring:message code="members.table.header.roles"/></th>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<th class='thtdData'><spring:message code="members.table.header.actions"/></th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members}" var="member">
				<tr class='dataRowHover'>
					<td class='thtdData'>${member.id}</td>
					<td class='thtdData'>${member.userCredentials.username}</td>
					<td class='thtdData'>${member.firstName}</td>
					<td class='thtdData'>${member.lastName}</td>
					<td class='thtdData'>${member.email}</td>
					<td class='thtdData'>${member.phone}</td>
					<td class='thtdData'>${member.address}</td>
					<td class='thtdData'>${member.userCredentials.authorities}</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					  <td class='thtdData'>
					  <security:authorize access="isAuthenticated()">
  						<security:authentication property="principal.username" var="currentUsername" />
					  </security:authorize>
					  
					  <a href="<spring:url value='/members/edit/${member.id}'/>"><spring:message code="members.table.row.edit"/></a>&nbsp;&nbsp;
					  <c:if test="${currentUsername ne member.userCredentials.username}" >
					  	<a href="<spring:url value='/members/delete/${member.id}'/>"><spring:message code="members.table.row.delete"/></a>
					  </c:if>
					  </td> 
					</security:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
