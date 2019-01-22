<!-- <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Test</title>
</head>
<body>

 <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://silva.computing.dundee.ac.uk/18agileteam4db"
     user="18agileteam4"  password="7632.at4.2367"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from exam_paper;
</sql:query>
<table>
<tr>
   <th>module_code</th>
   <th>format</th>
 
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.module_code"/></td>
   <td><c:out value="${row.format}"/></td>
 
</tr>
</c:forEach>
</table>
 
</body>
</html> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>JDBC Connection example</title>
</head>

<body>
<h1>JDBC Connection example</h1>

<%
  try {
    java.sql.Connection con;
    Class.forName("org.gjt.mm.mysql.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk/18agileteam4db", "18agileteam4", "7632.at4.2367");
    out.println (db+ "database successfully opened.");
  }
  catch(SQLException e) {
    out.println("SQLException caught: " +e.getMessage());++
  }
%>

</body>
</html>