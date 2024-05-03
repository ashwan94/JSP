package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPasswordServlet
 */
@WebServlet("/user/password")
public class UserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteId = request.getParameter("id");
		request.setAttribute("user", deleteId);
		request.getRequestDispatcher("/user/password.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPassword = request.getParameter("currentPassword");
		String password = request.getParameter("password");
		String deleteId = request.getParameter("id");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std121", "oracle21c");
			
			String query = "select id, name, email from member where id = ? and password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, deleteId);
			ps.setString(2, currentPassword);
			rs = ps.executeQuery();
			UserVO vo = null;
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				vo = new UserVO(id, name, null, email);
			}
			
			if(vo != null) {
				String updateSql = "update mmeber set password = ?, modify_date = sysdate where id = ?";
				ps = conn.prepareStatement(updateSql);
				ps.setString(1, password);
				ps.setString(2, deleteId);
				
				int result = ps.executeUpdate();
				if(result > 0) {
					response.sendRedirect("/user/list");
				}else {
					request.setAttribute("deleteId", deleteId);
					request.getRequestDispatcher("/user/password.jsp").forward(request, response);
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
