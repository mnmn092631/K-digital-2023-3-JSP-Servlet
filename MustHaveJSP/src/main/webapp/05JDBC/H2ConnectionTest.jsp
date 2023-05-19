<%@page import="java.sql.Connection"%>
<%@page import="common.H2Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>H2 연결 테스트</title>
</head>
<body>
	<h2>H2 테스트 1</h2>
	<%
	H2Connection h2Con = new H2Connection();
	Connection con = h2Con.getConnection();

	h2Con.writeMemberToTable(con, out);

	con.close();
	%>
	<br />
	<%
	String driver = application.getInitParameter("H2Driver");
	String url = application.getInitParameter("H2URL");
	String id = application.getInitParameter("H2Id");
	String pw = application.getInitParameter("H2Pw");

	H2Connection h2Con1 = new H2Connection(driver, url, id, pw);
	Connection con1 = h2Con1.getConnection();

	h2Con1.writeMemberToTable(con1, out);
	%>
</body>
</html>