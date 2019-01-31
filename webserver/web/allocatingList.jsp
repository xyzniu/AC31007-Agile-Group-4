<%@ page import="uk.ac.dundee.group4.pojo.ExamPaper" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.util.Category" %>
<%@ page import="uk.ac.dundee.group4.pojo.User" %><%--
User: xyzniu
Date: 2019-01-29
Time: 13:45
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

    <%
    User u = (User) session.getAttribute("user");
    %>

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
                <%
                if (u.getStaffType().equals(Category.LOCAL_EXAMS_OFFICER)) {
                %>
                <li>
                    <a href="ShowAllocateServlet">Allocate</a>
                </li>
                <li>
                    <a href="ShowAllocateServlet">Setting up</a>
                </li>
                <%
            }
            %>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>

            <h1>aaaaaa</h1>
            <%
            List<ExamPaper> examPapers = (List<ExamPaper>) request.getAttribute("examPapers");
            %>

            <%
            for (ExamPaper examPaper : examPapers) {
            %>
            <a href="AllocatingServlet?examPaperId=<%=examPaper.getId()%>"><%=examPaper.getModuleCode()%>
            </a>
            <%
        }
        %>
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
