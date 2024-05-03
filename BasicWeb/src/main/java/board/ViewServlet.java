package board;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/board/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DataSource dataSource = (DataSource) context.getAttribute("dataSource");

		BoardService service = new BoardService(dataSource);
		int no = Integer.parseInt(request.getParameter("no"));

		BoardVO vo = service.getBoard(no);
		request.setAttribute("board", vo);
		request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);

	}

}
