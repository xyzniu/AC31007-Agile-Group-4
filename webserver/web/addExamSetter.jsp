<%@ page import="uk.ac.dundee.group4.util.*" %>
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
                <li class="sidebar-brand"><a href="ListExamPaperServlet">Exam Work Flow System</a></li>
                <li><a href="ListExamPaperServlet">Dashboard</a></li>
                <li><a href="ListExamPaperServlet">Archive</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact Us</a></li>
                <li>
                    <a href="LogoutServlet">Logout</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!--page-content-wrapper-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
                <h1>Upload an Exam</h1>
                <hr>
                <form enctype="multipart/form-data" method="post" action="AddExamPaperServlet">
                    <!--module code input field-->
                    <div class="form-group">
                        <label for="InputModuleCode">Module Code:</label>
                        <input style="text-transform: uppercase;" type="text" class="form-control" maxlength="7" id ="InputModuleCode"  name="moduleCode" value="" required/>
                    </div>
                    <!--/module code input field-->
                    <!--Radio for format-->
                    <label>Format:</label>
                    <br>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio1" class="custom-control-input" name="format" value="<%=Category.PAPER_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio1">Paper Exam</label>
                    </div>

                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio2" class="custom-control-input" name="format" value="<%=Category.ONLINE_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio2">Online Exam</label>
                    </div>
                    <!--/Radio for format-->
                    <br>
                    <!--Radio for type-->
                    <label>Type:</label>
                    <br>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio3" class="custom-control-input" name="type" value="<%=Category.MAIN_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio3">Main Exam</label>
                    </div>

                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio4" class="custom-control-input" name="type" value="<%=Category.RECITE_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio4">Resit Exam</label>
                    </div>
                    <!--/Radio for type-->
                    <br>
                    <!--Radio for level-->
                    <label>Level:</label>
                    <br>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio5" class="custom-control-input" name="level" value="<%=Category.UNDERGRADUATE_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio5">Undergraduate Exam</label>
                    </div>

                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio6" class="custom-control-input" name="level" value="<%=Category.POSTGRADUATE_EXAM%>" required>
                        <label class="custom-control-label" for="customRadio6">Postgraduate Exam</label>
                    </div>
                    <!--/Radio for level-->
                    <br>
                    <!--Radio for semester-->
                    <label>Semester:</label>
                    <br>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio7" class="custom-control-input" name="semester" value="" required>
                        <label class="custom-control-label" for="customRadio7">Semester 1 (Weeks 1 - 14)</label>
                    </div>
                    
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadio8" class="custom-control-input" name="semster" value="" required>
                        <label class="custom-control-label" for="customRadio8">Semester 2 (Weeks 15 to 25)</label>
                    </div>
                    <!--/Radio for semester-->
                    <br>
                    <br>
                    <!--upload button-->
                    <div class="custom-file">
					<label class="custom-file-label" for="customFile">Choose a file to upload:</label>
                        <input type="file" class="custom-file-input" id="customFile" name="file" required/>

                    </div>
                    <!--/upload button-->
                    <br>
                    <br>
                    <!--submit button-->
                    <input type="submit" class="btn btn-primary" value="Submit"/>
                    <input type="submit" onclick="JavaScript:history.go(-1);return false;" class="btn btn-danger" value="Cancel"/>
                    <!--/submit button-->
                </form>
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
        <!--/scripts-->
        </div>
    </body>
    </html>
