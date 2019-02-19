<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>calender.html</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
	<%
		String msg = "";
		if (Calendar.AM_PM == Calendar.AM) {
			msg = "good morning";
		} else if (Calendar.AM_PM == Calendar.PM) {
			msg = "good afternoon";
		}
	%>
	test02
	<h2><%=msg%></h2>
</body>
</html>
