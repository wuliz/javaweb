<%@ page language="java" import="java.util.*" contentType="text/html; " pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'stu.jsp' starting page</title>



</head>

<body>
	<form action="http://localhost:8080/jspproject/CollectServlet?action=update"
		method="post">
		<table>
		<tr><td><input type="hidden" value="${collect.id}" name="id"></td></tr>
			<tr>
			
				<td>name:</td>
				<td><input type="text" name="name" value="${collect.name }"></td>
			</tr>
			<tr>
				<td>url:</td>
				<td><input type="text" name="url" value="${collect.url }"></td>
			</tr>
			<tr>
				<td colSpan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>

	<hr>

	

</body>
</html>
