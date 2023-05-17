<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	String snum = request.getParameter("num");
	
	if (type == null) type = "list";
	else {
		if (!type.equals("table")) type = "list";
	}
	
	int num = 2;
	if (snum != null) num = Integer.parseInt(snum);
	if (num == 0) num = 2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan Type1 (JSP)</title>
</head>
<body>
	<h2>구구단 타입 1</h2>
	<%
		if (type.equals("table")) {
			out.println("<table border='1'>");
			out.println("<tr><td>" + num + "단입니다.</td></tr>");
			for (int i = 1; i <= 9; i++) {
				out.println("<tr><td>" + num + " * " + i + " = " + num * i + "</td></tr>");
			}
			out.println("</table>");
		} else {
			out.println("<h3>" + num + "단입니다.</h3>");
			out.println("<ul>");
			for (int i = 1; i <= 9; i++) {
				out.println("<li>" + num + " * " + i + " = " + num * i + "</li>");
			}
			out.println("</ul>");
		}
	%>
</body>
</html>