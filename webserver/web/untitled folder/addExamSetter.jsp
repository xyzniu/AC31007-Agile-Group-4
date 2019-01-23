<%@ page import="uk.ac.dundee.group4.util.*" %><%--
  User: xyzniu
  Date: 2019-01-21
  Time: 18:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form enctype="multipart/form-data" method="post" action="AddExamPaperServlet">
    Module Code:<input name="moduleCode" value=""/>
    <br>
    Format:
    <br>
    <input type="radio" name="format" value="<%=Category.PAPER_EXAM%>" checked> paper exam
    <input type="radio" name="format" value="<%=Category.ONLINE_EXAM%>"> online exam
    <br>
    Type:
    <br>
    <input type="radio" name="type" value="<%=Category.MAIN_EXAM%>" checked> main exam
    <input type="radio" name="type" value="<%=Category.RECITE_EXAM%>"> recite exam
    <br>
    Level:
    <input type="radio" name="level" value="<%=Category.UNDERGRADUATE_EXAM%>" checked> undergraduate exam
    <input type="radio" name="level" value="<%=Category.POSTGRADUATE_EXAM%>"> postgraduate exam
    <br>
    upload files:
    <input type="file" name="file"/>
    <br>
    <input type="submit" value="submit"/>

</form>

</body>
</html>
