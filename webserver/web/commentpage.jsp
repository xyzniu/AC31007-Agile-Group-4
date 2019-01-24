<%@ page import="uk.ac.dundee.group4.pojo.SelectComment" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.dundee.group4.pojo.User" %>
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
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

        <%
        List<SelectComment> comments = (List<SelectComment>) request.getAttribute("comments_list");
        User u  = (User) session.getAttribute("user");
        String exam_paper_id = (String) request.getAttribute("exam_paper_id");
    %>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
            <h1>Welcome to your CommentPage!</h1>
            <hr>
            <a href="LogoutServlet" class="btn btn-danger" style="float: right;">Logout</a>
            <div style="clear: both;"></div>
            <hr>

            <div class="table-fixed">
                <table class="table table-bordered table-hover table-striped table table-fixed">
                    <thead>
                    <tr>
                        <th scope="col">Comments ID</th>
                        <th scope="col">CommentsUploader</th>
                        <th scope="col">Comments</th>

                    </tr>
                    </thead>
                    <tbody>

                    <%
                        int i = 0;
                        for (SelectComment comment : comments) {


                    %>
                    <tr>
                        <td><%=++i%>
                        </td>
                        <td><%=comment.getUser_id()%>
                        </td>
                        <td><%=comment.getComments()%>
                        </td>
                    </tr>

                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>



    </div>

    <div style="padding-left: 35px; padding-right: 35px;">
        <form action="InsertCommentServlet" method="post">
            <input type="hidden" name="user_id" value="<%=u.getId()%>"/>
            <input type="hidden" name="exam_paper_id" value="<%=exam_paper_id%>"/>
            <input type="hidden" name="staff_type" value="<%=u.getStaffType()%>"/>
            <textarea name="textfield3" class="form-control" rows="5" style="margin-left: auto; margin-right: auto; width: 100%;"
                      placeholder="Please input your comments..."></textarea>
            <br>
            <input type="submit" class="btn btn-success" value="submit" style="float: right;"/>
        </form>
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
