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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="AgileTeam4" content="">
    <title>Exam Work Flow Management System</title>
    <!--bootstrap and css-->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body>
<div id="wrapper" class="toggled">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="ListExamPaperServlet">
                    Exam Work Flow System
                </a>
            </li>
            <li>
                <a href="ListExamPaperServlet">Dashboard</a>
            </li>

            <li>
                <a href="ListExamPaperServlet">Archive</a>
            </li>
            <li>
                <a href="about.jsp">About</a>
            </li>
            <li>
                <a href="contact.jsp">Contact Us</a>
            </li>
            <li>
                <a href="LogoutServlet">Logout</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
            <br>
            <br>
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
                <div class="form-group">
                    <label for="formControlSelect1">Select Internal Moderator:</label>
                    <select class="form-control" id="formControlSelect1" size="8"
                            name="<%=Category.INTERNAL_MODERATOR%>" multiple="multiple" required>
                        <%
                            for (int i = 0; i < internalModerators.size(); i++) {
                                User u = internalModerators.get(i);
                                if (internalModeratorSet.contains(u.getId())) {
                        %>
                        <option value="<%= u.getId()%>"
                                selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
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
                </div>

                <div class="form-group">
                    <label for="formControlSelect2">Select Exam Vetting Committee Member:</label>
                    <select class="form-control" id="formControlSelect2" size="8"
                            name="<%=Category.EXAM_VETTING_COMMITTEE%>" multiple="multiple" required>
                        <%
                            for (int i = 0; i < committeeMember.size(); i++) {
                                User u = committeeMember.get(i);
                                if (committeeMemberSet.contains(u.getId())) {
                        %>
                        <option value="<%= u.getId()%>"
                                selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
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
                </div>

                <div class="form-group">
                    <label for="formControlSelect3">Select External Examiner:</label>
                    <select class="form-control" id="formControlSelect3" size="8" name="<%=Category.EXTERNAL_EXAMINER%>"
                            multiple="multiple" required>
                        <%
                            for (int i = 0; i < externalExaminer.size(); i++) {
                                User u = externalExaminer.get(i);
                                if (externalExaminerSet.contains(u.getId())) {
                        %>
                        <option value="<%= u.getId()%>"
                                selected="selected"><%=u.getFirstName() + " " + u.getLastName()%>
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
                </div>

                <!--submit button-->
                <input type="hidden" name="examPaperId" value="<%=examPaperId%>"/>
                <input class="btn btn-primary" type="submit" value="submit"/>
                <!--/submit button-->
            </form>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

    <!--scripts-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
    <!--/scripts-->
</body>
</html>                              