<%@ page language="java" import="java.util.*" contentType="text/html; " pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'stu.jsp' starting page</title>

<meta charset="utf-8">


</head>

<body>
	<form action="http://localhost:8080/jspproject/StuServlet"
		method="post">

		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td colSpan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>

	<hr>

	<c:forEach var="i" items="${list}">
	
	${i.id}
	${i.name }
	${i.age }
	<hr>
	</c:forEach>

</body>
</html>
