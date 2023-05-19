package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class H2Connection {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/musthave";
	private String id = "musthave";
	private String pw = "tiger";

	public H2Connection() {
	}

	public H2Connection(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pw);
	}
	
	public void writeMemberToTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		try {
			out.println("<table border = '1'>");
			out.write("<tr>");
			out.write("<td>id</td><td>pass</td><td>name</td><td>regidate</td>");
			out.write("</tr>");

			st = con.createStatement();
			rs = st.executeQuery("select * from member");

			while(rs.next()) {

				out.write("<tr>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("pass")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("name")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("regidate")); out.write("</td>");
				out.write("</tr>");

			}
			out.write("</table>");

			out.println("<table border='1'>");
			out.write("<tr>");
			out.write("<td>title</td><td>content</td><td>id</td><td>postdate</td>");
			out.write("</tr>");
			out.println("<br />");

			rs1 = st.executeQuery("select * from board");
			
			while(rs1.next()) {
				out.write("<tr>");
				out.write("<td>"); out.write(rs1.getString("title")); out.write("</td>");
				out.write("<td>"); out.write(rs1.getString("content")); out.write("</td>");
				out.write("<td>"); out.write(rs1.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs1.getString("postdate")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs1 != null)
					rs1.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public static void main(String[] args) throws Exception {
		H2Connection h2Con = new H2Connection();
		Connection con = h2Con.getConnection();

		con.close();
	}
	
}
