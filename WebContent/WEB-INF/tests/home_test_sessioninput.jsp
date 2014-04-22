<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travel Buddy is coming!</title>
</head>

<body>
Hi there from home!
<p/>
Session: <%= session.getAttribute("name") %>
<p/>
Request (using EL): ${name}
<p/>
<c:out value="With JSTL this becomes: ${name}"></c:out>

</body>
</html>