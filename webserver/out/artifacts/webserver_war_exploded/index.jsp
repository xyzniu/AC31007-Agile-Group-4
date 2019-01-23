<%@ page import="uk.ac.dundee.group4.util.Category" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<%
    String msg = (String) request.getAttribute("errorMsg");
    if (msg != null && msg.length() > 0) {
%>
<p><%=msg%>
</p>
<%
        request.removeAttribute("errorMsg");
    }
%>
<form action="LoginServlet" method="post">
    username: <input type="text" name="username" placeholder="username" value=""/><br>
    password: <input type="text" name="password" placeholder="password" value=""/><br>
    <select name="staff">
        <option value="<%=Category.EXAM_SETTER%>">ExamSetter</option>
        <option value="<%=Category.INTERNAL_MODERATOR%>">Internal Moderator</option>
        <option value="<%=Category.EXAM_VETTING_COMMITTEE%>">Exam Vetting Committee</option>
        <option value="<%=Category.EXTERNAL_EXAMINER%>">External Examiner</option>
        <option value="<%=Category.SCHOOL_OFFICE%>">School Office</option>
        <option value="<%=Category.SCHOOL_OFFICE%>">Local Exams Officer</option>
    </select>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
