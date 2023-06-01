package model2.mvcboard;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 게시물 불러오기
        MVCBoardDAO dao = new MVCBoardDAO();
        Connection con = dao.getConnection();
        String idx = req.getParameter("idx");
        dao.updateVisitCount(idx, con);  // 조회수 1 증가
        MVCBoardDTO dto = dao.selectView(idx, con);
        dao.closeConnection(con);

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        // 게시물(dto) 저장 후 뷰로 포워드
        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/14MVCBoard/View.jsp").forward(req, resp);
    }
}
