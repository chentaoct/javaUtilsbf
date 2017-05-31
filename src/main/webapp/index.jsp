<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/5/28
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()
            +":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <title>java工具类</title>
</head>
<body >
<h1>
 <a href="<%=basePath%>index/toIndex">javaUtils首页</a>

</h1>
<br>
一、项目描述
<br>



</body>
</html>
