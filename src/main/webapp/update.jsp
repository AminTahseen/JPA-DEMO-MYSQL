<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="post">
User Name
<input type="text" name="name" value="${uname}" readonly="readonly">

<br/>
User Job
<input type="text" name="job" value="${ujob}">

<br/>
<input type="submit" value="save"> 
</form>

</body>
</html>