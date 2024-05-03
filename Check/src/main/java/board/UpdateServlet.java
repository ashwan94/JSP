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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
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
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int updateNo = service.updateBoard(new BoardVO(no, writer, title, content));
		if(updateNo > 0) {
			response.sendRedirect("/board/list");
		}else {
			request.setAttribute("msg", "수정 실패");
			request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		}	
	}
}
