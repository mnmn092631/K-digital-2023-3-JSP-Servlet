package membership;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();

	public static void main(String[] args) {
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
		System.out.println(memberDTO);
	}

}
