
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
<!--

function onDeleteClick(event){	
	var doDelete = confirm("Are you sure you want to delete this offer?");
	
	if(doDelete == false){
		event.preventDefault();		
	}
}

function onReady(){
	$("#delete").click(onDeleteClick);
}

$(document).ready(onReady);

//-->
</script>

<form:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="review">
	<form:input type="hidden" path="id" name="id" />

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
			<td><input class="control" value="Save review" type="submit" /></td>
		</tr>

		<c:if test="${review.id !=0}">
			<tr>
				<td class="label"></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="delete control" name="delete" id="delete"
					value="Delete this review" type="submit" /></td>
			</tr>
		</c:if>
	</table>
</form:form>