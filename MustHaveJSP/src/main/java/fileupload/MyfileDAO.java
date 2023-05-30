package fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import common.JDBCConnect1;

public class MyfileDAO extends JDBCConnect1 {

	public int insertFile(MyfileDTO dto, Connection con) {
		int applyResult = 0;

		PreparedStatement psmt = null;
		
		try {
			String query = "INSERT INTO myfile (name, title, cate, ofile, sfile) VALUES (?, ?, ?, ?, ?)";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return applyResult;
	}

	public List<MyfileDTO> myFileList(Connection con) {
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();

		String query = "SELECT * FROM myfile ORDER BY idx DESC";

		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));

				fileList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("SELECT 시 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fileList;
	}
}
