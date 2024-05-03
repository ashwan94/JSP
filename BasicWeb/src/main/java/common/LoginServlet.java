package common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.RequestGroupInfo;

import member.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/common/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchId = request.getParameter("id");
		String searchPassword = request.getParameter("password");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std121", "oracle21c");
			String sql = "select id, name, email, create_date from member where id = ? and password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, searchId);
			statement.setString(2, searchPassword);
			resultSet = statement.executeQuery();
			MemberVO vo = null;
			if (resultSet.next()) {
				searchId = resultSet.getString("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date createDate = resultSet.getDate("create_date");
				vo = new MemberVO(searchId, name, email, createDate.toLocalDate());
			}
			if (vo != null) {
				// Server 에 사용자 정보를 저장하고 /member/list 로 이동
				// 세션은 HttpSession 이라는 객체를 통해서 관리할 수 있다
				HttpSession session = request.getSession();
				session.setAttribute("member", vo);
				// 브라우저가 종료되기 전까지 모든 page 에서 로그인된 사용자의 정보를 가져올 수 있음
				// 모든 page 에서 로그인 상태를 유지시킬 수 있다
				
				response.sendRedirect("/member/list");
				
			} else {
				// 지정한 사용자가 없으면 로그인 페이지에 해당하는 사용자가 없다는 메세지로 응답
				request.setAttribute("msg", "해당 사용자가 존재하지 않습니다.");
				request.getRequestDispatcher("/common/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
