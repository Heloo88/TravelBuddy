
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${destinations} == null">
	<c:out value="No destinations found"></c:out>
</c:if>
<c:forEach var="destination" items="${destinations}">
	<p>
		<c:out value="${destination}"></c:out>
	</p>
</c:forEach>