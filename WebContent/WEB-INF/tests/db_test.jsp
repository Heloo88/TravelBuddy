<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Welcome to Travel Buddy</title>
  </head>
  <body>
  
<sql:query var="rs" dataSource="jdbc/MySqlDB">
select id, name, description from Destination
</sql:query>

  <h2>Results DB Test</h2>

<c:forEach var="row" items="${rs.rows}">
    Id ${row.id}<br/>
    Name ${row.name}<br/>
</c:forEach>

  </body>
</html>