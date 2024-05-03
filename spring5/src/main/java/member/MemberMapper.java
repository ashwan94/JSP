package member;

import java.util.List;

import common.SearchVO;

public interface MemberMapper {
	
	int getMemberTotalCount(SearchVO vo);
	public List<MemberVO> getMemberList(SearchVO vo);
	public MemberVO getMember(String id);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(String id);
	public MemberVO currentPassword(MemberVO vo);
	public int changePassword(MemberVO vo);	
}
