<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/"> Click here to return
		home.</a>

	<table class="reviews">
		<tr>
			<td>Title</td>
			<td>Rating</td>
			<td>Description</td>
		</tr>
		<c:forEach var="review" items="${reviews}">
			<tr>
				<td><c:out value="${review.title}"></c:out></td>
				<td><c:out value="${review.rating}"></c:out></td>
				<td><c:out value="${review.description}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>