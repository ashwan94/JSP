package board;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

/**
 * controller 역할
 */
@MultipartConfig(location = "/Users/na/tools/eclipse-workspace/StepUp/temp")
@WebServlet("/board/add")
public class InsertServlet extends HttpServlet {
	private BoardService service;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new BoardService(session);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// view 에서 전달받은 첨부파일 Server 로 전송하기
		// 이미 request 에 첨부파일에 대한 정보가 담겨있다
		// Servlet 3.0 부터 사용 가능한 part
		
		// 모든 <input> 은 multiple/form-data 로 전송 시 part 에 담긴다
		// 이때 파일을 제외한 나머지는 request.getParameter() 로 가져오는게 편하고,
		// 첨부파일만 getPart() 를 통해 가져온다
//		Part part = request.getPart("uploadFile"); // 첨부파일 1개만 꺼내기
//		
//		// 업로드된 첨부파일의 크기를 알고 싶을때
//		long size = part.getSize();
//		
//		// 업로드된 첨부파일의 이름
//		String fileName = part.getSubmittedFileName();
//		
//		// 파일 쓰기
//		// part 에 저장된 data 는 temp 에 저장되는데, 시간이 지나면 알아서 삭제된다
//		// 파일 저장 후 즉시 삭제하고 싶다면 delete() 를 사용하면 된다
//		part.write("/Users/na/tools/eclipse-workspace/StepUp/temp/" + fileName);
//		part.delete();
		
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			String contentType = part.getContentType();
			
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				
				if(part.getSize() > 0) {
					part.write("/Users/na/tools/eclipse-workspace/StepUp/temp/" + fileName);
					part.delete();
				}
			} else {
				String value = request.getParameter(part.getName());
			}
		}
		
		int insertBoard = service.insertBoard(new BoardVO(writer, title, content));
		if (insertBoard > 0) {
			// 등록 성공
			response.sendRedirect("/board/list");
		} else {
			// 등록 실패
			request.setAttribute("msg", "등록 실패");
			request.getRequestDispatcher("/WEB-INF/views/board/add.jsp").forward(request, response);
		}
	}

}
