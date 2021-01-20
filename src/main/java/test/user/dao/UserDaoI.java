package test.user.dao;

import java.util.List;

import test.user.vo.UserVo;
import test.vo.PageVo;

public interface UserDaoI {
	//로그인 시 입력한 값이 있는지 확인
	int userlogin(UserVo vo);
	
	//전체 회원 리스트
	List<UserVo> allUserList();
	
	//페이징한 사용자 조회
	List<UserVo> selectPagingUser(PageVo vo);

	//아이디로 검색
	List<UserVo> idFindUser(String userid);
	int idFindUserCount(String userid);
	
	//이름으로 검색
	List<UserVo> nameFindUser(String usernm);
	int nameFindUserCount(String usernm);
	
	//별명으로 검색
	List<UserVo> aliasFindUser(String alias);
	int aliasFindUserCount(String alias);
	
	//선택한 회원 조회
	UserVo selectUser(String userid);
	
	//전체 회원수 카운트
	int countUser();
}
