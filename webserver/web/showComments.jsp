<%@ page import="uk.ac.dundee.group4.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.pojo.Comment" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <%
        List<Comment> comment = (List<Comment>) request.getAttribute("comments");
        for(Comment c : comment){
    %>
        <%= c.getComment_id()%>
        <%= c.getComments()%>
    <%
        }
    %>

</p>
</body>
</html>
