<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>JDBC 테스트 1</h2>
	<%
	JDBCConnection jdbcCon = new JDBCConnection();
	Connection con = jdbcCon.getConnection();
	
	jdbcCon.writeMemberToTable(con, out);
	
	con.close();
	%>
	<br />
	<%
	String driver = application.getInitParameter("MySQLDriver");
	String url = application.getInitParameter("MySQLURL");
	String id = application.getInitParameter("MySQLId");
	String pw = application.getInitParameter("MySQLPw");
	
	JDBCConnection jdbcCon1 = new JDBCConnection(driver, url, id, pw);
	Connection con1 = jdbcCon1.getConnection();
	
	jdbcCon.writeMemberToTable(con1, out);
	%>
</body>
</html>