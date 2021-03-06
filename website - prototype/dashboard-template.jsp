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
                    <a href="dashboard.jsp">Dashboard</a>
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


        <div id="page-content-wrapper">
            <div class="container-fluid">
            	<a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
                <p>Time: <%= new java.util.Date() %></p>
                <h1>Welcome to your Dashboard!</h1>
                <p>contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent contentcontentcontent 
                </p>
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

