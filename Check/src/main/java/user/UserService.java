package user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserService {
	private final UserMapper mapper;
	
	public UserService(SqlSession session) {
		this.mapper = session.getMapper(UserMapper.class);
	}
	public List<UserVO> getUserList(){
		return mapper.getUserList();
	}
	public UserVO getUser(String id) {
		return mapper.getUser(id);
	}
	public int insertUser(UserVO vo) {
		return mapper.insertUser(vo);
	}
	public int updateUser(UserVO vo) {
		return mapper.updateUser(vo);
	}
	public int deleteUser(UserVO vo) {
		return mapper.deleteUser(vo);
	}
	public UserVO currentPassword(UserVO vo) {
		return mapper.currentPassword(vo);
	}
	public int changePassword(UserVO vo) {
		return mapper.changePassword(vo);
	}
	
}
