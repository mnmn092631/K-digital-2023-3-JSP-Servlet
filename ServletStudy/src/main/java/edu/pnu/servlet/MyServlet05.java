package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet05")
public class MyServlet05 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet04");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<table border=\"1\">\n"
				+ "<tr>\n"
				+ "<th>번호</th>\n"
				+ "<th>나라</th>\n"
				+ "<th>수도</th>\n"
				+ "<th>인구</th>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>1</td>\n"
				+ "<td>대한민국</td>\n"
				+ "<td>서울</td>\n"
				+ "<td>1000만</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>2</td>\n"
				+ "<td>미국</td>\n"
				+ "<td>워싱턴</td>\n"
				+ "<td>70만</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>3</td>\n"
				+ "<td>일본</td>\n"
				+ "<td>도쿄</td>\n"
				+ "<td>1400만</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>4</td>\n"
				+ "<td>중국</td>\n"
				+ "<td>베이징</td>\n"
				+ "<td>2100만</td>\n"
				+ "</tr>\n"
				+ "</table>");
		out.close();
		
	}
}
