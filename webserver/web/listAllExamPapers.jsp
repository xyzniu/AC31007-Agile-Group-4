<%@ page import="uk.ac.dundee.group4.pojo.ExamPaper" %>
<%@ page import="uk.ac.dundee.group4.util.Category" %>
<%@ page import="uk.ac.dundee.group4.pojo.User" %>
<%@ page import="java.util.List" %><%--
User: xyzniu
Date: 2019-01-21
Time: 17:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="AgileTeam4" content="">
    <title>Exam Workflow Management System</title>

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
                <a href="#">
                    Exam Workflow System
                </a>
            </li>
            <li>
                <a href="dashboard.html">Dashboard</a>
            </li>
            <li>
                <a href="#">My Exams</a>
            </li>
            <li>
                <a href="#">Archive</a>
            </li>
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->

        <%
        User u = (User) session.getAttribute("user");
        %>

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
            <h1><%=u.getFirstName() + " " + u.getLastName()%>, Welcome to your Dashboard!</h1>
            <hr>
            <%
                if (u.getStaffType().equals(Category.EXAM_SETTER)) {
            %>
            <a href="addExamSetter.jsp" class="btn btn-primary">Add</a>
            <a href="LogoutServlet" class="btn btn-danger" style="float: right;">Logout</a>
            <hr>
            <%
                }
            %>
            <%
                List<ExamPaper> examPapers = (List<ExamPaper>) request.getAttribute("examPapers");
                if (examPapers == null || examPapers.size() == 0) {
            %>
            <p>No exam papers.</p>
            <%
            } else {
            %>
            <div class="table-fixed">
                <table class="table table-bordered table-hover table-striped table table-fixed">
                    <thead>
                    <tr>
                        <th  scope="col">Exam Paper ID</th>
                        <th scope="col">Module Code</th>

                        <%
                            if (!u.getStaffType().equals(Category.EXAM_SETTER)) {
                        %>
                        <th scope="col">Exam Setter</th>
                        <%
                            }
                        %>
                        <th scope="col">Format</th>
                        <th scope="col">Type</th>
                        <th scope="col">Level</th>
                        <th scope="col">Stage</th>
                        <th scope="col">Timestamp</th>
                        <th scope="col">Download</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        int i = 0;
                        for (ExamPaper examPaper : examPapers) {
                    %>
                    <tr>
                        <td><a href="addExamSetter.jsp"><%= ++i%>
                        <td><a href=""><%= examPaper.getModuleCode()%>
                                <%if (!u.getStaffType().equals(Category.EXAM_SETTER)) {%>
                        <td><a href=""><%= examPaper.getExamSetter()%>
                                <% }%>
                                <%if(examPaper.getFormat()==Category.ONLINE_EXAM){
                                %>
                        <td><a href="">Online paper
                                <%}else{%>
                        <td><a href="">Paper exam
                                <% } %>

                                <% if(examPaper.getType()==Category.MAIN_EXAM){  %>
                        <td><a href="">Main exam
                                <%}else{%>
                        <td><a href="">Resit Exam
                                <% } %>

                                <% if(examPaper.getLevel()==Category.UNDERGRADUATE_EXAM){ %>
                        <td><a href="">Undergraduate exam
                                <%}else{%>
                        <td><a href="">Postgraduate Exam
                                <% } %>


                        <td><a href="">
                            <%
                                String str = null;
                                int stage = examPaper.getStage();
                                if (stage == Category.TO_SIGN_BY_INTERNAL_MODERATOR) {
                                    str = "To be signed by Internal Moderator";
                                } else if (stage == Category.TO_SIGN_BY_EXAM_VETTING_COMMITTEE) {
                                    str = "To be signed by Exam Vetting Committee";
                                } else if (stage == Category.TO_SIGN_BY_EXTERNAL_EXAMINER) {
                                    str = "To be signed by External Examiner";
                                } else {
                                    str = "Completed";
                                }
                            %>
                            <%=str%>
                        </a></td>
                        <td><a href=""><%= examPaper.getTimestamp()%>
                        </a></td>
                        <td>
                            <a href="DownloadServlet?moduleCode=<%=examPaper.getModuleCode()%>&level=<%=examPaper.getLevel()%>">download</a>
                        </td>

                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
            <%}%>
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
