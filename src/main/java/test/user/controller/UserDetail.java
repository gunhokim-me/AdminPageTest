package test.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.user.service.UserService;
import test.user.service.UserServiceI;
import test.user.vo.UserVo;

@WebServlet("/userDetail.do")
public class UserDetail extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		UserVo vo = service.selectUser(userid);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/memberDetail.jsp").forward(req, resp);
	}
}
