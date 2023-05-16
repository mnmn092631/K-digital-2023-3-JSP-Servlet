<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="common.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 영역</title>
</head>
<body>
	<h2>application 영역의 속성 읽기</h2>
	<%
	Map<String, Object> maps = (Map<String, Object>) application.getAttribute("maps");
	Set<String> keys = maps.keySet();
	for (String key : keys) {
		Object object = maps.get(key);
		if (object instanceof Person) {
			Person person = (Person) object;
			out.print(String.format("Key : %s, 이름 : %s, 나이 : %d<br />", key, person.getName(), person.getAge()));
		}
		else if (object instanceof ArrayList) {
			ArrayList<String> lists = (ArrayList<String>) object;
			for (String str : lists) {
				out.print(String.format("Key : %s, Value : %s<br />", key, str));
			}
		}
		else {
			out.print(String.format("Key : %s, Value : %s<br />", key, object));
		}
	}
	%>
</body>
</html>