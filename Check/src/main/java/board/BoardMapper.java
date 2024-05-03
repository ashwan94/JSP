package board;

import java.util.List;

import common.SearchVO;
import user.UserVO;

public interface BoardMapper {
	List<BoardVO> getBoardList(SearchVO vo);
	BoardVO getBoard(int searchNo);
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(int deleteNo);
}
