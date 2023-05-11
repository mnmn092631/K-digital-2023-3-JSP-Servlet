<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
public int add(int num1, int num2) {
	return num1 + num2;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
	<%
	int result = add(10, 20);
	
	String snum1 = request.getParameter("num1");
	int num1 = 0;
	if(snum1 != null) num1 = Integer.parseInt(snum1);
	
	String snum2 = request.getParameter("num2");
	int num2 = 0;
	if(snum2 != null) num2 = Integer.parseInt(snum2);
	%>
	덧셈 결과 1 : <%= result %> <br />
	덧셈 결과 2 : <%= add(30, 40) %> <br />
	파라미터 덧셈 결과 : <%=num1 %> + <%=num2 %> = <%= add(num1, num2) %>
</body>
</html>