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
<title>myjsp.jsp</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
	<h2>Test jsp</h2>
	<ul>
		<!--声明成员变量和成员方法  -->
		<li><%!int age = 30;
	String name = "amaker";

	public String hello() {
		return "hello," + name;
		
	}%>
	<!-- 表达式，相当于out.println() -->
			<h2>
				调用上面声明<%=hello()%></h2> Current time:<%=new Date().toString()%></li>
		<li>Server:<%=application.getServerInfo()%>
		</li>
		<li>session:<%=session.getId()%>

		</li>
		<!-- 代码快，service方法中执行 -->
		<%
			System.out.println("hello");
		%>
	</ul>

</body>
</html>
