<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sel = request.getParameter("sel");
	String val = request.getParameter("val");
	
	if (sel.equals("gugudanType1")) {
		// response.sendRedirect("Gugudan1.jsp?num=" + val);
		request.getRequestDispatcher("Gugudan1.jsp?num=" + val).forward(request, response);
	}
	else {
		// response.sendRedirect("Gugudan2.jsp?col=" + val);
		request.getRequestDispatcher("Gugudan2.jsp?col=" + val).forward(request, response);
	}
%>