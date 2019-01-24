<%@ page import="uk.ac.dundee.group4.pojo.User" %>
<%@ page import="java.util.List" %><%--
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
        List<User> users = (List<User>) request.getAttribute("users");
        for(User u : users){
    %>
        <%= u.getId()%>
        <%= u.getName()%>
        <%= u.getPassword()%>
    <%
        }
    %>

</p>
</body>
</html>
