package board;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	private BoardService service;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new BoardService(session);
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deleteNo = Integer.parseInt(request.getParameter("no"));
        int deletedBoard = service.deleteBoard(deleteNo);
        if (deletedBoard > 0) {
            response.sendRedirect("/board/list");
        } else {
            request.setAttribute("msg", "삭제 실패");
            request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
        }
    }
}
