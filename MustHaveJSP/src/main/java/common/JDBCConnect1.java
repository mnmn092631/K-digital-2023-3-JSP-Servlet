package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnect1 {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pw = "tiger";
	
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pw);
	}
	
	public static void main(String[] args) throws Exception {
		JDBCConnect1 jdbcConnect = new JDBCConnect1();
		Connection con = jdbcConnect.getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from board");
		while(rs.next()) {
			System.out.println(String.format("%s. %s, %s", rs.getString("title"), rs.getString("content"), rs.getString("id")));
		}
		
		System.out.println();
		
		ResultSet rs1 = st.executeQuery("select * from member");
		while(rs1.next()) {
			System.out.println(String.format("%s. %s, %s", rs1.getString("id"), rs1.getString("pass"), rs1.getString("name")));
		}
		
		con.close();
	}
	
}
