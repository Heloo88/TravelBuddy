
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<table class="reviews">
	<tr>
		<th>Title</th>
		<th>User</th>
		<th>Rating</th>
		<th>Description</th>
	</tr>
	<c:forEach var="review" items="${reviews}">
		<tr>
			<td><c:out value="${review.title}"></c:out></td>
			<td><c:out value="${review.user.name}"></c:out></td>			
			<td><c:out value="${review.rating}"></c:out></td>
			<td><c:out value="${review.description}"></c:out></td>
		</tr>
	</c:forEach>
</table>
<p/>


<c:choose>
<c:when test="${hasReview}">
	<p><a href="${pageContext.request.contextPath}/createreview">Edit or delete your current review.</a></p>
</c:when>
<c:otherwise>
	<p><a href="${pageContext.request.contextPath}/createreview">Add a new review.</a></p>
</c:otherwise>
</c:choose>

<!-- <p><a href="${pageContext.request.contextPath}/reviews">Show current reviews.</a></p -->


<p><a href="${pageContext.request.contextPath}/destinations">Show current destinations.</a></p>
<p><a href="${pageContext.request.contextPath}/createdestination">Add a new destination.</a></p>




<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="<c:url value='/admin'/>">Admin</a></p>
</sec:authorize>
