package employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employees")
// 위 code 가 사용자로부터 요청받은 data 내용
// 해당 URL 로 이동하라는 명령어 같은 것
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmployeeVO> employees = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			// 2. 접속 정보로 접속
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std121", "oracle21c");
//			Connection connection = DriverManager.getConnection("jdbc:apache:commons:dbcp:chapter17");
			

			// 3. 작업 편집기(워크시트)를 생성해준다
			Statement statement = connection.createStatement();

			// 4. 쿼리 작성
			String sql = "select employee_id, emp_name, email, phone_number, hire_date from employees";

			// 5.쿼리 실행
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");
				String empName = resultSet.getString("emp_name");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phone_number");
				Date hireDate = resultSet.getDate("hire_date");
				
				// DB 에서 읽어들인 column data 를 풀생성자의 속성으로 만들어주고, 이걸 또 List 에 담아줌
				employees.add(new EmployeeVO(employeeId, empName, email, phoneNumber, hireDate.toLocalDate()));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/employees.jsp").forward(request, response);
	}

}
