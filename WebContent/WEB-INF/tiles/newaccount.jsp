<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<form:form id="details" method="post"
	action="${pageContext.request.contextPath}/createaccount"
	commandName="user">
	<table class="formtable">
		<tr>
			<td class="label">Username:</td>
			<td><form:input name="username" path="username" type="text" /><br />
				<div class="error">
					<form:errors path="username"></form:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Name:</td>
			<td><form:input name="name" path="name" type="text" /><br />
				<div class="error">
					<form:errors path="name"></form:errors>
				</div></td>
		</tr>		
		<tr>
			<td class="label">Email:</td>
			<td><form:input name="email" path="email" type="text" /><br />
				<div class="error">
					<form:errors path="email"></form:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Password:</td>
			<td><form:input name="password" id="password" path="password"
					type="password" /><br />
				<div class="error">
					<form:errors path="password"></form:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Confirm password:</td>
			<td><input name="confirmpassword" id="confirmpass"
				type="password" />
				<div id="matchpass"></div></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input value="Create account" type="submit" /></td>
		</tr>


	</table>
</form:form>
