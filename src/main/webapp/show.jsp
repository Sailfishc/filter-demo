<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show.jsp' starting page</title>
    
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
<table align="center" width="60%" border="1">
  <tr>
    <th>客户端IP</th>
    <th>客户端访问次数</th>
  </tr>

<c:forEach items="${applicationScope.map }" var="entry">
  <tr>
    <td>${entry.key }</td>
    <td>${entry.value }</td>
  </tr>
</c:forEach>
</table>
  </body>
</html>
