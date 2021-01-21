package test.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.user.dao.UserDao;
import test.user.dao.UserDaoI;
import test.user.vo.UserVo;
import test.vo.PageVo;

public class UserService  implements UserServiceI{
	
	private UserDaoI dao = new UserDao();
	@Override
	public int userlogin(UserVo vo) {
		return dao.userlogin(vo);
	}

	@Override
	public List<UserVo> allUserList() {
		return dao.allUserList();
	}
	
	//페이징 처리
	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.countUser();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//아이디로 검색한 페이징
	@Override
	public Map<String, Object> idFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.idFineUserPaging(vo);
		int userCnt = dao.idFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//이름으로 검색한 페이징
	@Override
	public Map<String, Object> nameFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.nameFindUserPaging(vo);
		int userCnt = dao.nameFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//별명으로 검색한 페이징
	@Override
	public Map<String, Object> aliasFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.aliasFindUserPaging(vo);
		int userCnt = dao.aliasFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//선택한 회원 조회
	@Override
	public UserVo selectUser(String userid) {
		return dao.selectUser(userid);
	}

	//전체 회원 수 조회
	@Override
	public int countUser() {
		return dao.countUser();
	}

	//회원 등록
	@Override
	public int registUser(UserVo vo) {
		return dao.registUser(vo);
	}

	//회원 수정
	@Override
	public int modifyUser(UserVo vo) {
		return dao.modifyUser(vo);
	}

	//회원 삭제
	@Override
	public int deleteUser(String userid) {
		return dao.deleteUser(userid);
	}

}
