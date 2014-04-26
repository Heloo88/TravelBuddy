<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Welcome to Travel Buddy</title>
</head>
<body>

	<p><a href="${pageContext.request.contextPath}/destinations">Show current destinations.</a></p>
	<p><a href="${pageContext.request.contextPath}/createDestination">Add a new destination.</a></p>
	<p><a href="${pageContext.request.contextPath}/reviews">Show current reviews.</a></p>
	<p><a href="${pageContext.request.contextPath}/createReview">Add a new review.</a></p>


	<sec:authorize access="!isAuthenticated()">
		<p><a href="<c:url value='/login'/>">Log in</a></p>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<p><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></p>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p><a href="<c:url value='/admin'/>">Admin</a></p>
	</sec:authorize>
</body>
</html>