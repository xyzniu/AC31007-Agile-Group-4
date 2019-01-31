<%@ page import="uk.ac.dundee.group4.util.*" %><%--
  Created by IntelliJ IDEA.
  User: chenjingkun
  Date: 2019/1/28
  Time: 20:10
  To change this template use File | Settings | File Templates.
  --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
  	<title>Title</title>
  </head>
  <body>
  	<div id="page-content-wrapper">
  		<div class="container-fluid">
  			<a href="#menu-toggle" class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></a>
  			<h1>Upload an Exam</h1>
  			<hr>

  			<form enctype="multipart/form-data" method="post" action="InsertCommentFileServlet">


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
  </body>
  </html>
