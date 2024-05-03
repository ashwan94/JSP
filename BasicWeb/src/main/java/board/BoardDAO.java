package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BoardDAO {

	private DataSource dataSource;

	public BoardDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		// Connection conn; 으로만 선언하게 되면 지역변수일때 초기값이 지정되지 않으므로 try-catch 안에서 에러가 난다.
		// 전역 변수는 자동으로 초기화되기 때문에 해당 사항이 없다.
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			// Table join 이 필요함
			String sql = 
					"""
				select
					a.no
					,b.name as writer
					,a.title
					,a.create_date
					,hits
				from
					board a
					inner join member b on a.writer = b.id
				""";
			// 본래 alias 를 사용할때 as 를 표기하는게 맞으나, 생략이 가능하므로 기재하지 않아도 됨
			// 현장에서 생략가능하다는 의미는 안 쓰는게 낫다는 의미임
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				Date createDate = rs.getDate("create_date");
				int hits = rs.getInt("hits");
				list.add(new BoardVO(no, writer, title, createDate.toLocalDate(), hits));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public BoardVO getBoard(int searchNo) {
		BoardVO vo = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			// Table join 이 필요함
			String sql = 
					"""
				select
					a.no
					,b.name as writer
					,a.title
					,a.content
					,a.create_date
					,a.modify_date
					,hits
				from
					board a
					inner join member b on a.writer = b.id
				where no = ?
				""";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, searchNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				Date createDate = rs.getDate("create_date");
				int hits = rs.getInt("hits");
				vo = new BoardVO(no, writer, title, createDate.toLocalDate(), hits);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vo;
	}
	
	public int insertBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into board (writer, title, content) values (?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getContent());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int updateBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			String query = "update board set title = ?, content = ? , modify_date = SYSDATE where no = ?";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
	
	public void deleteBoard(int deleteNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "delete from board where no = ?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, deleteNo);
			
			int result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
