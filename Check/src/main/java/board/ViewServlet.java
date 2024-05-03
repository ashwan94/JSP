package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/board/view")
public class ViewServlet extends HttpServlet {
	private BoardService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession)servletContext.getAttribute("sqlSession");
		this.service = new BoardService(session);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchNo = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = service.getBoard(searchNo);
		request.setAttribute("board", vo);
		request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
	}
}
