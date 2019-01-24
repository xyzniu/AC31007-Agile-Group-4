<%--
  User: xyzniu
  Date: 2019-01-24
  Time: 13:52
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
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->


    <div id="page-content-wrapper">
        <div class="container-fluid">
            <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
            <h1>Central Contact Details</h1>
            <h3>
                Contact Us:
            </h3>
            <pre>
Main telephone switchboard
+44 (0)1382 383 000
Mon - Fri 09:00 - 17:00
                </pre>
            <pre>
Admissions enquiries
+44 (0)1382 38 38 38
                </pre>
            <pre>
Human Resources
+44 (0)1382 386 999
hr@dundee.ac.uk
                </pre>
            <pre>
Principal's Office
+44 (0)1382 38 55 62
principal@dundee.ac.uk
                </pre>
            <h3>Address:
            </h3>
            <pre>
University of Dundee
Nethergate
Dundee
DD1 4HN
Scotland, UK
                    </pre>


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


