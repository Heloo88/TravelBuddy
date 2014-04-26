<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);
		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password != confirmpass) {
			alert("PW don't match!");
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {
			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' /> ");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");

			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
				$("#matchpass").removeClass("valid");
				$("#matchpass").addClass("error");

			}
		}
	}

	$(document).ready(onLoad);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register user</title>
</head>
<body>

	<h2>Create New Account</h2>

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
				<td><input name="confirmpassword" id="confirmpass" type="password" />
					<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input value="Create account" type="submit" /></td>
			</tr>


		</table>
	</form:form>

</body>
</html>