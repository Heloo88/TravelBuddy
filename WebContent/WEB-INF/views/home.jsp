<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

</body>
</html>