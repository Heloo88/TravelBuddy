<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="${pageContext.request.contextPath}/docreate">
<table>
<tr><td>Title: </td><td><input name="title" type=text/></td></tr>
<tr><td>Rating: </td><td><input name="rating" type="number" min="1" max="10"/></td></tr>
<tr><td>Description: </td><td><textarea rows="5" cols="25"></textarea></td></tr>
<tr><td></td><td><input value="Create review" type="submit"/></td></tr>


</table>
</form>

</body>
</html>