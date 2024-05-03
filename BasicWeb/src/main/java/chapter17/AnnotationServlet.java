package chapter17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/anno", "/tation"})
// Servlet 에서는 배열이 {} 임
// value 를 생략하면 default 가 value 임
// value 가 빨간 글씨인 이유는 dark mode라서...
public class AnnotationServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().print("이 페이지는 어노테이션 페이지입니다.");
	}
}
