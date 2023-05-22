package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();

	public static void printAllMember() {
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for (MemberDTO m : list) {
			System.out.println(m);
		}
	}

	public static void main(String[] args) {
		{
			MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
			System.out.println(memberDTO);

			// 모든 회원 정보 출력
			printAllMember();
		}

		{
			// 입력
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId("아무거나");
			memberDTO.setPass("1111");
			memberDTO.setName("아무개");
			memberDAO.insertMemberDTO(memberDTO);
			printAllMember();
		}
	}

}
