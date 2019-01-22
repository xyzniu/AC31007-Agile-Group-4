<%@ page import="uk.ac.dundee.group4.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.pojo.Comment" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/22
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>insertComment</title>
</head>
<body>
<h1>Please in put the comment_id to delete</h1>
<ul>
    <li><p><b>comment_id:</b>
        <%= request.getParameter("comment_id")%>
    </p></li>
</ul>
</body>
</html>