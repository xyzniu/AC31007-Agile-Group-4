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
            <h1><%=u.getFirstName() + " " + u.getLastName()%>, Welcome to your Dashboard!</h1>
            <hr>
            <%
                if (u.getStaffType().equals(Category.EXAM_SETTER)) {
            %>

            <!-- button input group start -->
            <div class="input-group mb-3">
                    <div class="input-group-prepend">
                            <a href="addExamSetter.jsp" class="btn btn-primary">Add</a>
                    </div>
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">
                    <div class="input-group-append">
                            <a href="LogoutServlet" class="btn btn-danger">Logout</a>
                </div>
                </div>
            <!-- /button input group end -->

            <%
                }
            %>

            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null && msg.length() > 0) {
            %>
            <p><%=msg%>
            </p>
            <%
                    request.removeAttribute("msg");
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
                <table class="table table-bordered table-hover table-striped table table-fixed table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Exam Paper ID</th>
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
                        <th scope="col">Semester</th>
                        <th scope="col">Stage</th>
                        <th scope="col">Timestamp</th>
                        <th scope="col">Download</th>
                        <th scope="col">Review</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <%
                        int i = 0;
                        for (ExamPaper examPaper : examPapers) {
                    %>
                    <tr>
                        <td><%= ++i%>
                        <td><%= examPaper.getModuleCode()%>
                                <%if (!u.getStaffType().equals(Category.EXAM_SETTER)) {%>
                        <td><%= examPaper.getExamSetter()%>
                                <% }%>
                                <%if(examPaper.getFormat()==Category.ONLINE_EXAM){
                                %>
                        <td>Online exam
                                <%}else{%>
                        <td>Paper exam
                                <% } %>

                                <% if(examPaper.getType()==Category.MAIN_EXAM){  %>
                        <td>Main exam
                                <%}else{%>
                        <td>Resit Exam
                                <% } %>

                                <% if(examPaper.getLevel()==Category.UNDERGRADUATE_EXAM){ %>
                        <td>Undergraduate exam
                                <%}else{%>
                        <td>Postgraduate Exam
                                <% } %>

                        <!-- placeholder -->
                        <td>Semester 1</td>

                        <td>
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
                        <td><%= examPaper.getTimestamp()%>
                        </a></td>
                        <%
                            switch (u.getStaffType()) {
                                case Category.EXAM_SETTER:
                                case Category.SCHOOL_OFFICE:
                                case Category.LOCAL_EXAMS_OFFICER:
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary" href="DownloadServlet?examPaperId=<%=examPaper.getId()%>">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning" href="SelectCommentServlet?exam_paper_id=<%=examPaper.getId()%>">Review</a>
                        </td>
                        <%
                                break;
                            case Category.INTERNAL_MODERATOR:
                                if (examPaper.getStage() != Category.TO_SIGN_BY_INTERNAL_MODERATOR) {
                                    %>
                                    <td style="text-align: center;">
                                        <a class="btn btn-primary disabled" href="#">download</a>
                                    </td>
                                    <td style="text-align: center;">
                                        <a class="btn btn-warning disabled" href="#">Review</a>
                                    </td>
                                    <%
                                } else {
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary" href="DownloadServlet?examPaperId=<%=examPaper.getId()%>">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning" href="SelectCommentServlet?exam_paper_id=<%=examPaper.getId()%>">Review</a>
                        </td>
                        <%
                                }
                                break;
                            case Category.EXAM_VETTING_COMMITTEE:
                                if (examPaper.getStage() != Category.TO_SIGN_BY_EXAM_VETTING_COMMITTEE) {
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary disabled" href="#">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning disabled" href="#">Review</a>
                        </td>
                        <%

                        } else {
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary" href="DownloadServlet?examPaperId=<%=examPaper.getId()%>">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning" href="SelectCommentServlet?exam_paper_id=<%=examPaper.getId()%>">Review</a>
                        </td>
                        <%
                                }
                                break;
                            case Category.EXTERNAL_EXAMINER:
                                if (examPaper.getStage() != Category.TO_SIGN_BY_EXTERNAL_EXAMINER) {
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary disabled" href="#">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning disabled" href="#">Review</a>
                        </td>
                        <%
                        } else {
                        %>
                        <td style="text-align: center;">
                            <a class="btn btn-primary" href="DownloadServlet?examPaperId=<%=examPaper.getId()%>">download</a>
                        </td>
                        <td style="text-align: center;">
                            <a class="btn btn-warning" href="SelectCommentServlet?exam_paper_id=<%=examPaper.getId()%>">Review</a>
                        </td>
                        <%
                                    }
                                    break;
                            }
                        %>


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
    <script>
            $(document).ready(function(){
              $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
              });
            });
            </script>

    <!--/scripts-->


</body>
</html>
