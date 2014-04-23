<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TravelBuddy is here</title>
</head>
<body>

	<form:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="review">
		<table class="formtable">
			<tr>
				<td class="label">Title:</td>
				<td><form:input name="title" path="title" type="text" /><br />

					<form:errors path="title" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="label">Rating:</td>
				<td><form:input name="rating" path="rating" type="number"
						min="1" max="10" /><br /> <form:errors path="description"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="label">Description:</td>
				<td><form:textarea name="description" path="description"
						rows="5" cols="25"></form:textarea><br /> <form:errors
						path="description" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input value="Create review" type="submit" /></td>
			</tr>


		</table>
	</form:form>

</body>
</html>