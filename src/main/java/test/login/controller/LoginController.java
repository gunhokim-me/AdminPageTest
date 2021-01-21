package test.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.user.service.UserService;
import test.user.service.UserServiceI;
import test.user.vo.UserVo;

@WebServlet("/login.do")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		UserServiceI service = new UserService();
		UserVo vo = new UserVo();
		vo.setUserid(userid);
		vo.setPass(pass);
		int cnt = service.userlogin(vo);
		
		if(cnt == 1) {
			HttpSession session = req.getSession();
			UserVo vo2 = new UserVo();
			vo2 = service.selectUser(userid);
			session.setAttribute("S_USER", vo2);
			List<UserVo> userList = service.allUserList();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/paging.do").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+ "/login.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
