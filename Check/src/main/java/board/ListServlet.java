package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private BoardService service;
       
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession)servletContext.getAttribute("sqlSession");
		this.service = new BoardService(session);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		List<BoardVO> list = service.getBoardList(new SearchVO(searchType, searchWord));
		request.setAttribute("boards", list);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

}
