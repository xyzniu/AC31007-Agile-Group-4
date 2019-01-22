<%@ page import="uk.ac.dundee.group4.pojo.ExamPaper" %>
<%@ page import="uk.ac.dundee.group4.util.Category" %>
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
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
        
        <!-- /#page-content-wrapper -->     
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
                <h1>Welcome to your Dashboard! (example)</h1>
                <hr>
                <a href="addExamSetter.jsp" class="btn btn-primary">Add</a>
                <a href="#" class="btn btn-success">Other buttons maybe?</a>
                <hr>
                <%
                List<ExamPaper> examPapers = (List<ExamPaper>) request.getAttribute("examPapers");
                    if (examPapers == null || examPapers.size() == 0) {
                        %>
                        <p>No exam papers.</p>
                        <%
                    } else {
                        %>
                        <div class = "table-responsive">
                            <table class = "table table-bordered table-hover table-striped table">
                                <thead>
                                    <tr>
                                        <th scope="col">Exam Paper ID</th>
                                        <th scope="col">Module Code</th>
                                        <th scope="col">Exam Setter</th>
                                        <th scope="col">Format</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Level</th>
                                        <th scope="col">Version</th>
                                        <th scope="col">Timestamp</th>
                                        <th scope="col">Download</th>
                                    </tr>    
                                </thead>
                                <tbody>
                                    <%
                                    for (ExamPaper examPaper : examPapers) {
                                    %>
                                    <tr>
                                        <td><a href=""><%= examPaper.getId()%>
                                        <td><a href=""><%= examPaper.getModuleCode()%>
                                        <td><a href=""><%= examPaper.getExamSetterId()%>
                                                       
                                            <%
                                                if(examPaper.getFormat()==Category.ONLINE_EXAM){
                                            %>
                                            <td><a href="">Online paper
                                            <%}else{%>
                                            <td><a href="">Paper exam
                                            <% } %>
                                            <td><a href=""><%= examPaper.getFormat()%>
                                            
                                            <%
                                                if(examPaper.getType()==Category.MAIN_EXAM){
                                            %>
                                            <td><a href="">Main exam
                                            <%}else{%>
                                            <td><a href="">Resit Exam
                                            <% } %>
                                            <td><a href=""><%= examPaper.getType()%>
                                                         
                                            <%
                                            if(examPaper.getLevel()==Category.UNDERGRADUATE_EXAM){
                                            %>  
                                            <td><a href="">Undergraduate exam
                                            <%}else{%>
                                            <td><a href="">Postgraduate Exam
                                            <% } %>
                                            <td><a href=""><%= examPaper.getLevel()%>
                                                       
                                            <td><a href=""><%= examPaper.getLatestVersion()%></a></td>
                                            <td><a href=""><%= examPaper.getTimestamp()%></a></td>
                                            <td><a href="">download</a></td>
                                                        
                                        </tr>
                                        <%}%>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                        <th>Exam Paper ID</th>
                                        <th>Module Code</th>
                                        <th>Exam Setter</th>
                                        <th>Format</th>
                                        <th>Type</th>
                                        <th>Level</th>
                                        <th>Version</th>
                                        <th>Timestamp</th>
                                        <th>Download</th>
                                    </tr>
                                    </tfoot>
                            </table>
                        </div>
                        <%}%> 
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
        </div>
                                                                    
</body>
</html>
                                                                