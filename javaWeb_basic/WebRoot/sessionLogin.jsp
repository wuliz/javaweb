<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sessionLogin.jsp' starting page</title>
    
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
   ${error}
    <form action="/javaWeb_basic/SessionLoginServlet" method="post">
    <table>
    <tr>
    <td>name:</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
    <td>password:</td>
    <td><input type="password" name="psw"></td>
    </tr>
    </table>
    <button type="submit">提交</button>
    </form>
  </body>
</html>
