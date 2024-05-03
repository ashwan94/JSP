package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 data 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		// session 에 담겨있던 member 라는 object 가 삭제됨
		
		// 만약 세션의 모든 정보를 삭제하고자 한다면 invalidate() 를 호출한다
		session.invalidate();
		response.sendRedirect("/member/list");
		
	}

}
