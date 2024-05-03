package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DataSource dataSource = (DataSource) context.getAttribute("dataSource");

		BoardService service = new BoardService(dataSource);
		int no = Integer.parseInt(request.getParameter("no"));

		BoardVO vo = service.getBoard(no);
		request.setAttribute("board", vo);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DataSource dataSource = (DataSource) context.getAttribute("dataSource");
		
		BoardService service = new BoardService(dataSource);
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = service.updateBoard(new BoardVO(no, writer, title, content));

		if(result > 0) {
			// 등록 성공
			response.sendRedirect("/board/list");
		}else {
			// 등록 실패
			request.setAttribute("msg", "등록 요청에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		}
	}

}
