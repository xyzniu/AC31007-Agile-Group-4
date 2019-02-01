<%@ page import="uk.ac.dundee.group4.util.Category" %>
<%@ page import="uk.ac.dundee.group4.pojo.User" %>
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

<%
    User u = (User) session.getAttribute("User");
%>

<body>
<div id="wrapper" class="toggled">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand"><a href="ListExamPaperServlet">Exam Work Flow System</a></li>
            <li><a href="ListExamPaperServlet">Dashboard</a></li>
            <li><a href="ListExamPaperServlet">Archive</a></li>
            <li><a href="about.jsp">About</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
            <%
                if (u.getStaffType().equals(Category.LOCAL_EXAMS_OFFICER)) {
            %>
            <li><a href="ShowAllocateServlet">Allocate</a></li>
            <%
                }
            %>
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
            <h1>Contact Details</h1>
            <hr>

            <div class="card" style="width: 50%;">
                <div class="card-header">Contact Us:</div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">Telephone</h6>
                    <p>+44 (0)1382 383 000 <br> Mon - Fri 09:00 - 17:00</p>
                    <h6 class="card-subtitle mb-2 text-muted">Admission Enquiries</h6>
                    <p>+44 (0)1382 38 38 38</p>
                    <h6 class="card-subtitle mb-2 text-muted">Human Resources</h6>
                    <p>+44 (0)1382 386 999 <br> hr@dundee.ac.uk</p>
                    <h6 class="card-subtitle mb-2 text-muted">Principal's Office</h6>
                    <p>+44 (0)1382 38 55 62 <br> principal@dundee.ac.uk</p>
                </div>
            </div>

            <br>

            <div class="card" style="width: 50%;">
                <div class="card-header">Address:</div>
                <div class="card-body">
                    <address class="card-text">University of Dundee <br> Nethergate <br> Dundee <br> DD1 4HN <br>
                        Scotland, UK <br></address>
                </div>
            </div>
        </div>
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
</div>
</body>

<footer>

</footer>
</html>


