<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBCConnect1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	JDBCConnect1 jdbc = new JDBCConnect1();
	Connection con = jdbc.getConnection();

	if (con == null) {
		out.print("Fail to connect Database!");
		return;
	}

	String sql = "SELECT id, pass, name, regidate FROM member";
	Statement stmt = con.createStatement();

	ResultSet rs = stmt.executeQuery(sql);

	while (rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");

		out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br />");
	}

	jdbc.closeConnection(con);
	%>
</body>
</html>