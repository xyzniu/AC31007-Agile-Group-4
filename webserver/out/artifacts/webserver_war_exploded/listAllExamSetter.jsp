<%@ page import="uk.ac.dundee.group4.pojo.ExamPaper" %>
<%@ page import="java.util.List" %><%--
  User: xyzniu
  Date: 2019-01-21
  Time: 17:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Exam Setter</title>
</head>
<body>

<a href="addExamSetter.jsp">add one</a>
<%
    List<ExamPaper> examPapers = (List<ExamPaper>) request.getAttribute("examPapers");
    if (examPapers == null || examPapers.size() == 0) {
%>
<p>No exam papers.</p>
<%
} else {
%>
<table>
    <%
        for (ExamPaper examPaper : examPapers) {
    %>
    <tr>
        <td><a href=""><%= examPaper.getModuleCode()%>
        </a></td>

        <td><a href="">download</a></td>
    </tr>
    <%
        }


    %>
</table>
<%
    }
%>

</body>
</html>
