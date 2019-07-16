<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
${msg}
<br/>
<a href="addPage">Create New</a>
<table>
<thead>
<tr>
<th>User ID</th>
<th>User Names</th>
<th>User Jobs</th>
<th>User Actions</th>
</tr>
</thead>

<c:forEach var="s" items="${list}">

<tbody>
<tr>
<td>${s.user_id}</td>
<td>${s.user_name}</td>
<td>${s.user_job}</td>

<td>
<form action="UpdatePage">
<input type="hidden" name="name" value="${s.user_name}">
<input type="submit" value="update">
</form>
</td>

<td>
<form action="delete">
<input type="hidden" name="name" value="${s.user_name}">
<input type="submit" value="delete">
</form>
</td>

</tr>
</tbody>

</c:forEach>

</table>


</body>
</html>