<%@ page import="uk.ac.dundee.group4.util.Category" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<<<<<<< HEAD
  <head>
    <title>index</title>
  </head>
  <body>
  <a href="CommentServlet"> go to Show Comment servlet</a>
  <a href="insertComment.jsp"> go to Insert Comment servlet</a>
  <a href="deleteComment.jsp"> go to Delete Comment servlet</a>
  <a href="updateComment.jsp"> go to Update Comment servlet</a>
  <a href="selectComment.jsp"> go to Select Comment servlet</a>
  </body>
=======
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="AgileTeam4" content="">
        <title>Exam Workflow Management System</title>

        <!--bootstrap and css-->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
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
<div class="card" style="width: 500px; align-content: center; margin: auto;">
    <img class="card-img-top" src="dundeelogo.png" alt="Card image" style="margin: auto;">
    <div class="card-body">
        <h4 class="card-title">Login</h4>
        <h6 class="card-subtitle mb-2 text-muted">Please enter your login details and select your role</h6>
        <hr>
        <form action="LoginServlet" method="post">
            <div class="form-group" style="margin: auto;">
                <input class="form-control" type="text" name="username" placeholder="username" value=""/><br>
                <input class="form-control" type="text" name="password" placeholder="password" value=""/><br>
            </div>
            <select name="staff" class="form-control">
                <option value="<%=Category.EXAM_SETTER%>">ExamSetter</option>
                <option value="<%=Category.INTERNAL_MODERATOR%>">Internal Moderator</option>
                <option value="<%=Category.EXAM_VETTING_COMMITTEE%>">Exam Vetting Committee</option>
                <option value="<%=Category.EXTERNAL_EXAMINER%>">External Examiner</option>
                <option value="<%=Category.SCHOOL_OFFICE%>">School Office</option>
                <option value="<%=Category.LOCAL_EXAMS_OFFICER%>">Local Exams Officer</option>
            </select><br>
            <input class="btn btn-primary" type="submit" value="login"/>
        </form>
    </div>
</div>
</body>
>>>>>>> niu
</html>
