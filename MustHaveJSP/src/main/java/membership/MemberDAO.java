package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCConnect1;

public class MemberDAO extends JDBCConnect1 {

	public MemberDAO() {
	}

	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";

		Connection con = getConnection();
		if (con == null) return null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	// 모든 회원 정보를 반환합니다.
	public ArrayList<MemberDTO> getAllMemberDTO() {
		String query = "SELECT * FROM member";

		Connection con = getConnection();
		if (con == null) return null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<MemberDTO> list = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(query);

			list = new ArrayList<>();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	// 회원 정보를 추가합니다.
	public int insertMemberDTO(MemberDTO member) {
		String query = "INSERT INTO member(id, pass, name) VALUES (?, ?, ?)";

		Connection con = getConnection();
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int inResult = 0;

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			inResult = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return inResult;
	}

	// 회원 정보를 수정합니다.
	public int updateMemberDTO(MemberDTO member) {
		String query = "UPDATE member SET pass=?, name=? WHERE id=?";
		
		Connection con = getConnection();
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int inResult = 0;

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getPass());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getId());
			inResult = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return inResult;
	}

	// 회원 정보를 삭제합니다.
	public int deleteMemberDTO(String uid) {
		String query = "DELETE FROM member WHERE id=?";

		Connection con = getConnection();
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int inResult = 0;

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			inResult = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return inResult;
	}

}
