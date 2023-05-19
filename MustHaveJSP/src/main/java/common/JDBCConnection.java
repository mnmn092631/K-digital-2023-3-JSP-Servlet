package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class JDBCConnection {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pw = "tiger";

	public JDBCConnection() {
	}

	public JDBCConnection(String driver, String url, String id, String pw) {
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

		try {
			out.write("<table boder='1'>");
			out.write("<tr>");
			out.write("<td>id</td><td>pass</td><td>name</td><td>regidate</td>");
			out.write("</tr>");

			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			while (rs.next()) {
				out.write("<tr>");
				out.write("<td>");
				out.write(rs.getString("id"));
				out.write("</td>");
				out.write("<td>");
				out.write(rs.getString("pass"));
				out.write("</td>");
				out.write("<td>");
				out.write(rs.getString("name"));
				out.write("</td>");
				out.write("<td>");
				out.write(rs.getString("regidate"));
				out.write("</td>");
				out.write("</tr>");

			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
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
	}

}
