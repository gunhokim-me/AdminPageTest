package test.user;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import test.user.dao.UserDao;
import test.user.dao.UserDaoI;
import test.user.vo.UserVo;

public class UserDaoTest {
	
	UserDaoI dao = new UserDao();
	@Before
	public void BeforeTest() {
	}
	
	@Test
	public void SelectUserCountTest() {
		/***Given***/
		String userid = "brown";
		String pass = "brown";
		UserVo vo = new UserVo();
		vo.setUserid(userid);
		vo.setPass(pass);
		
		/***When***/
		int cnt = dao.userlogin(vo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void allUserTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> list = dao.allUserList();
		/***Then***/
		assertEquals(16, list.size());
	}
	
	
	@Test
	public void selectLikeUserTest() {
		/***Given***/
		String userid ="brown%";
		/***When***/
		List<UserVo> list = dao.selectLikeUser(userid);
		/***Then***/
		assertEquals(1, list.size());
	}

}
