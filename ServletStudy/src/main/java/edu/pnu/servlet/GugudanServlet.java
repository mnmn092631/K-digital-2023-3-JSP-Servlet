package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String type = req.getParameter("type");
		String snum = req.getParameter("num");
		int num = 2;
		if (snum != null)
			num = Integer.parseInt(snum);
		if (type == null || type == "")
			type = "list";

		try (PrintWriter out = resp.getWriter();) {
			out.println("<h1>" + num + "단입니다.</h1>");

			if (type.equals("table")) {
				out.println("<table border='1'>");
				for (int i = 1; i <= 9; i++) {
					out.println("<tr><td>" + num + " * " + i + " = " + num * i + "</td></tr>");
				}
				out.println("</table>");
			} else {
				out.println("<ul>");
				for (int i = 1; i <= 9; i++) {
					out.println("<li>" + num + " * " + i + " = " + num * i + "</li>");
				}
				out.println("</ul>");
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
