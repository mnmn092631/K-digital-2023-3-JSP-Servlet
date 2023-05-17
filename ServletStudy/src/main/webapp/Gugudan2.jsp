<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String scol = request.getParameter("col");
	
	int col = 1;
	if (scol != null) col = Integer.parseInt(scol);
	if (col == 0) col = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan Type2 (JSP)</title>
</head>
<body>
	<h2>구구단 타입 2</h2>
	<table border="1">
	<% for (int i = 2; i <= 9; i += col) {			
		for (int k = 1; k <= 9; k++) { %>
		<tr>
		<% for (int j = 0; j < col; j++) { 
				if (9 < i + j) break; %>
				<td><%= i + j %> * <%= k %> = <%= (i + j) * k %></td>
			<% } %>
		</tr>
		<% } %>
	<% } %>
	</table>
</body>
</html>