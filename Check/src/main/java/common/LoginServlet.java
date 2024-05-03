package common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import user.UserService;
import user.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new UserService(session);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchId = request.getParameter("id");
		String searchPassword = request.getParameter("password");
		boolean saveFlag = Boolean.parseBoolean(request.getParameter("saveId"));
		Cookie cookie = new Cookie("savedId", searchId);
		
		if(saveFlag) {
			cookie.setMaxAge(60 * 60 *24 * 365);
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		
		
		UserVO vo = service.currentPassword(new UserVO(searchId, searchPassword));
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			response.sendRedirect("/user/list");
		}else {
			request.setAttribute("msg", "해당하는 정보가 없습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(request, response);
		}
	}

}
