package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DataSource dataSource = (DataSource) context.getAttribute("dataSource");

		BoardService service = new BoardService(dataSource);
		
		int boardNo = Integer.parseInt(request.getParameter("no"));
		service.deleteBoard(boardNo);

		response.sendRedirect("/board/list");
		
	}


}
