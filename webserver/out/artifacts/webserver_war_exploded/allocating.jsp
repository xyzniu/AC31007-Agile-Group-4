<%@ page import="uk.ac.dundee.group4.util.Category" %>
<%@ page import="uk.ac.dundee.group4.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashSet" %><%--
  User: xyzniu
  Date: 2019-01-28
  Time: 16:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allocating</title>
</head>
<body>

<%
    List<List<User>> users = (List<List<User>>) request.getAttribute("users");
    List<User> internalModerators = users.get(0);
    List<User> committeeMember = users.get(1);
    List<User> externalExaminer = users.get(2);
    List<HashSet<Integer>> sets = (List<HashSet<Integer>>) request.getAttribute("links");
    HashSet<Integer> internalModeratorSet = sets.get(1);
    HashSet<Integer> committeeMemberSet = sets.get(2);
    HashSet<Integer> externalExaminerSet = sets.get(3);
    String examPaperId = (String) request.getAttribute("examPaperId");
    request.setAttribute("examPaperId", examPaperId);
%>

<form action="AllocatingServlet" method="post">
    <select size="5" name="<%=Category.INTERNAL_MODERATOR%>" multiple="multiple" required>
        <%
            for (int i = 0; i < internalModerators.size(); i++) {
                User u = internalModerators.get(i);
                if (internalModeratorSet.contains(u.getId())) {
        %>
        <option value="<%= u.getId()%>" selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
        } else {
        %>
        <option value="<%= u.getId()%>"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
                }
            }
        %>
    </select>

    <select size="5" name="<%=Category.EXAM_VETTING_COMMITTEE%>" multiple="multiple" required>
        <%
            for (int i = 0; i < committeeMember.size(); i++) {
                User u = committeeMember.get(i);
                if (committeeMemberSet.contains(u.getId())) {
        %>
        <option value="<%= u.getId()%>" selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
        } else {
        %>
        <option value="<%= u.getId()%>"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
                }
            }
        %>
    </select>

    <select size="5" name="<%=Category.EXTERNAL_EXAMINER%>" multiple="multiple" required>
        <%
            for (int i = 0; i < externalExaminer.size(); i++) {
                User u = externalExaminer.get(i);
                if (externalExaminerSet.contains(u.getId())) {
        %>
        <option value="<%= u.getId()%>" selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
        } else {
        %>
        <option value="<%= u.getId()%>"><%=u.getFirstName() + " " + u.getLastName()%>
        </option>
        <%
                }
            }
        %>
    </select>

    <input type="hidden" name="examPaperId" value="<%=examPaperId%>"/>

    <input type="submit" value="submit"/>
</form>

</body>
</html>
