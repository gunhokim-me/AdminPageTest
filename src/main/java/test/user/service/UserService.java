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
	
	//����¡ ó��
	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.countUser();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//���̵�� �˻��� ����¡
	@Override
	public Map<String, Object> idFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.idFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//�̸����� �˻��� ����¡
	@Override
	public Map<String, Object> nameFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.nameFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	//�������� �˻��� ����¡
	@Override
	public Map<String, Object> aliasFindUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.aliasFindUserCount(vo.getVal());
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	@Override
	public UserVo selectUser(String userid) {
		return dao.selectUser(userid);
	}

	@Override
	public int countUser() {
		return dao.countUser();
	}

}
