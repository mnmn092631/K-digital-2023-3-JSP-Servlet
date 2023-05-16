<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
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
	<h2>application 영역의 공유</h2>
	<%
	Map<String, Object> maps = new HashMap<>();
	maps.put("actor1", new Person("이수일", 30));
	maps.put("actor2", new Person("심순애", 28));
	
	// page
	maps.put("pageInteger", 1000);
	maps.put("PageString", "페이지 영역의 문자열");
	maps.put("pagePerson", new Person("한석봉", 99));
	
	// request
	maps.put("requestString", "request 영역의 문자열");
	maps.put("requestPerson", new Person("안중근", 31));
	
	// session
	ArrayList<String> lists = new ArrayList<>();
	lists.add("리스트");
	lists.add("컬렉션");
 	maps.put("lists", lists);
	
	application.setAttribute("maps", maps);
	%>
	application 영역에 속성이 저장되었습니다.
</body>
</html>