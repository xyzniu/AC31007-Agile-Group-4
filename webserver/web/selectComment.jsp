<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.pojo.Comment" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/23
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="uk.ac.dundee.group4.pojo.SelectComment" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>select Comment</title>
</head>
<body>
<h1>show the comment</h1>

<form   method="post" action="SelectCommentServlet">
    comment_id: <input type="text" name="comment_id">
    <br />

    <input type="submit" value="submit" />
    <span class="error">${error}</span>
</form>

</body>
</html>