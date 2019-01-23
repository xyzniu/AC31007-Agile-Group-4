<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.pojo.SelectComment" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/22
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all the comments</title>
</head>
<body>
<p>
    <%
        List<SelectComment> selectcomment = (List<SelectComment>) request.getAttribute("comments_list");
        for(SelectComment c : selectcomment){
    %>
    <%= c.getComment_id()%>
    <%= c.getComments()%>
    <%
        }
    %>

</p>

</body>
</html>

