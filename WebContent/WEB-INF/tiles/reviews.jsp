
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



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

<p>
<a href="${pageContext.request.contextPath}/"> Click here to return
	home.</a>
</p>