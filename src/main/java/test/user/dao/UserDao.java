package test.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import test.db.MybatisUtil;
import test.user.vo.UserVo;
import test.vo.PageVo;

public class UserDao implements UserDaoI {

	//로그인 할 때 아이디와 비밀번호가 맞는지 확인
	@Override
	public int userlogin(UserVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.select",vo);
		session.close();
		return cnt;
	}

	//전체 회원 리스트 가져오기
	@Override
	public List<UserVo> allUserList() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.userAllList");
		session.close();
		return list;
	}

	//페이징한 사용자 조회
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.selectPagingUser",vo);
		session.close();
		return userList;
	}
	
	//아이디로 검색
	@Override
	public List<UserVo> idFindUser(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.idFindUser", userid);
		session.close();
		return list;
	}
	
	//아이디로 검색 한 회원 수
	@Override
	public int idFindUserCount(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.idFindUserCount", userid);
		session.close();
		return cnt;
	}
	
	//아이디로 검색한 회원 페이징
	@Override
	public List<UserVo> idFineUserPaging(PageVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.idFineUserPaging",vo);
		session.close();
		return userList;
	}

	//이름으로 검색
	@Override
	public List<UserVo> nameFindUser(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.nameFindUser", usernm);
		session.close();
		return list;
	}

	//이름으로 검색 한 회원 수
	@Override
	public int nameFindUserCount(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.nameFindUserCount", usernm);
		session.close();
		return cnt;
	}
	
	//이름으로 검색한 회원 페이징
	@Override
	public List<UserVo> nameFindUserPaging(PageVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.nameFindUserPaging",vo);
		session.close();
		return userList;
	}
	
	//별명으로 검색
	@Override
	public List<UserVo> aliasFindUser(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.aliasFindUser", alias);
		session.close();
		return list;
	}

	//별명으로 검색한 회원 수
	@Override
	public int aliasFindUserCount(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.aliasFindUserCount", alias);
		session.close();
		return cnt;
	}
	
	//별명으로 검색한 회원 페이징
	@Override
	public List<UserVo> aliasFindUserPaging(PageVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.aliasFindUserPaging",vo);
		session.close();
		return userList;
	}
	//선택한 회원 조회
	@Override
	public UserVo selectUser(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		UserVo vo = session.selectOne("users.selectUser", userid);
		session.close();
		return vo;
	}

	//전체 회원 카운트
	@Override
	public int countUser() {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.countUser");
		session.close();
		return cnt;
	}
	
	//회원 등록
	@Override
	public int registUser(UserVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.insert("users.registUser",vo);
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return cnt;
	}

	//회원 수정
	@Override
	public int modifyUser(UserVo vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.update("users.modifyUser",vo);
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return cnt;
	}

	//회원 삭제
	@Override
	public int deleteUser(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.delete("users.deleteUser",userid);
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return cnt;
	}

}
