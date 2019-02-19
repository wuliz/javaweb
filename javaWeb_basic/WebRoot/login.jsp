<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<!-- 从prepateServlet中过来，如果请求中带有用户信息，则放入文本框中 -->
	<form action="/javaWeb_basic/LoginServlet" method="post">
	<% %>
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name" value="${name}"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="psw" value="${psw }"></td>
			</tr>
			<tr>
				<td>是否自动登录？</td>
				<td><input type="checkbox" value="yes" name="auto"></td>
			</tr>
			
			<tr>
			<td><input type="submit">登录</td>
			</tr>
		</table>
	</form>
</body>
</html>
