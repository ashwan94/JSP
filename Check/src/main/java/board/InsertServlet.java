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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/board/add")
public class InsertServlet extends HttpServlet {
	private BoardService service;
      
	@Override
		public void init() throws ServletException {
			ServletContext servletContext = getServletContext();
			SqlSession session = (SqlSession)servletContext.getAttribute("sqlSession");
			this.service = new BoardService(session);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/add.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int insertBoard = service.insertBoard(new BoardVO(writer, title, content));
		if(insertBoard > 0) {
			response.sendRedirect("/board/list");
		}else {
			request.setAttribute("msg", "존재하지 않는 정보입니다.");
			request.getRequestDispatcher("/WEB-INF/views/board/add.jsp").forward(request, response);
		}
		
	}

}
