package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.PaginationInfo;
import common.SearchVO;

// Controller 역할을 한다.
@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private BoardService service;

	@Override
	public void init() throws ServletException {
        ServletContext context = getServletContext();
        SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");
        service = new BoardService(sqlSession);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		// 페이징 관련 코드
		String pageNo = request.getParameter("currentPageNo");
		System.out.println(pageNo);
		System.out.println("페이지 번호");
		int currentPageNo = pageNo == null ? 1 : Integer.parseInt(pageNo);
		// 실행 시 currentPageNo 는 반드시 1 을 보장
		System.out.println("현재 페이지 번호");
		System.out.println(currentPageNo);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(5);
		SearchVO vo = new SearchVO(searchType, searchWord);
		
		int totalCount = service.getBoardListCount(vo); // DB 의 board Table 의 모든 data 개수를 가져옴
		paginationInfo.setTotalRecordCount(totalCount); // pagination 에 가져온 DB 모든 board 개수 저장
		
		// 페이징된 게시글 목록을 가져오기 위해
		vo.setFirstRecordIndex(paginationInfo.getFirstRecordIndex()); // SearchVO 에 paginationInfo 의 첫, 마지막 RecordIndex 정보 저장
		vo.setLastRecordIndex(paginationInfo.getLastRecordIndex());
		
		List<BoardVO> list = service.getBoardList(vo);
		request.setAttribute("boards", list);
		request.setAttribute("pagination", paginationInfo);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}
}
