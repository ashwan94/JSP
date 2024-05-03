package chapter17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
//		2. 깨지는 글을 인코딩해줌
		resp.getWriter().print("이 페이지는 서블릿으로 응답된 페이지입니다.");
//		1. 한글은 깨진다
	}
}