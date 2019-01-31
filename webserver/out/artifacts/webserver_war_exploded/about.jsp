<%--
  User: xyzniu
  Date: 2019-01-24
  Time: 13:50
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
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
            <h1>About</h1>
            <p> The Workflow management system the School of Science and Engineering has in place for computing staff allows exam setters to track the progress of their paper throughout the review process.
            </p>
            <p> The internal moderators, external examiners and exam committee members are permitted access to download the previous version of the exam paper, upload the reviewed version with the attached comments and sign the file containing the certain stage’s final version of the exam.
            </p>
            <p> Members of the school office are allowed to view and download the final version of the exam paper.
            </p>
            <p>The local exam officer has access to all versions of all exams and can see the progress of all exam papers being reviewed at the time. He has admin rights over the entire system and can send warning messages to members who are approaching their deadline. All other users but the local exam officer have access to their own deadlines.
            </p>
            <p>The School of Science and Engineering hopes that this automated system will make our jobs easier and set a clear expectation for when the exam paper review process will be completed for each individual examination.
                When are the degree exam diets?
            </p>

            <table class="table table-bordered table-hover table-sm">
                <thead class="thead">
                <tr>
                    <th scope="col">Exam Diet</th>
                    <th scope="col">Month</th>
                    <th scope="col">Timetable published</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Semester 1 diet</th>

                    <td>December</td>
                    <td>October</td>

                </tr>
                <tr>
                    <th scope="row">Semester 2 diet</th>

                    <td>April</td>
                    <td>May</td>
                </tr>
                <tr>
                    <th scope="row">Resit</th>

                    <td>July</td>
                    <td>At least two weeks before</td>
                </tr>

                </tbody>

                <table class="table table-bordered table-hover table-sm">
                    <thead class="thead">
                    <tr>
                        <th scope="col">Venue</th>
                        <th scope="col">Location</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Accountancy LR</th>

                        <td>This is within 1 Perth Road</td>

                    </tr>
                    <tr>
                        <th scope="row">Bonar Hall</th>

                        <td>The Main Hall on the ground floor of the Bonar Hall</td>

                    </tr>
                    <tr>
                        <th scope="row">Dalhousie</th>

                        <td>Rooms in the Dalhousie building are numbered according to their Block and Floor Level.</td>

                    </tr>
                    <tr>
                        <th scope="row">Sports Hall 2</th>

                        <td>In the Institute of Sport and Exercise; the entrance to SH2 for exam purposes is in Kincardine Street, the side road between the ISE and Heathfield</td>

                    </tr>
                    <tr>
                        <th scope="row">Tower IT Suites (A, B, C D or E) </th>

                        <td>Located in the Basement of the Tower Building</td>

                    </tr>
                    </tbody>
                </table>


                The University of Dundee is a registered Scottish Charity, No: SC015096


            </table>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

    <!--scripts-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</div>
</body>

<footer>

</footer>
</html>

