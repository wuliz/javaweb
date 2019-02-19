<%@ page language="java" import="java.util.*" contentType="text/html; "
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'stu.jsp' starting page</title>



</head>

<body>
	<form
		action="http://localhost:8080/jspproject/CollectServlet?action=save"
		method="post">
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>url:</td>
				<td><input type="text" name="url"></td>
			</tr>
			<tr>
				<td colSpan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>

	<hr>
	<form
		action=""
		id="delform" method="post">
		<c:forEach var="i" items="${list}">
	${i.id}
	${i.name }
	<a href="${i.url}}">${i.url }</a>
			<a
				href="http://localhost:8080/jspproject/CollectServlet?action=get&id=${i.id }">Edit</a>
			<input type="checkbox" name="ids" value="${i.id }">
			<hr>

		</c:forEach>
		<button type="" id="del">删除</button>
	</form>
</body>
<script type="text/javascript">
	var id = document.getElementById("del");
	id.onclick = function() {
		if (confirm("你确定要删除吗？")) {
			var f = document.getElementById("delform");
			f.action = "http://localhost:8080/jspproject/CollectServlet?action=delete";
			f.submit();
		} else {
			return;
		}
	}
</script>
</html>
