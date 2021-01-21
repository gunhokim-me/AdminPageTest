package test.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.user.service.UserService;
import test.user.service.UserServiceI;

@WebServlet("/delete.do")
public class DeleteUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		
		int res = service.deleteUser(userid);
		
		if(res == 1) {
			req.getRequestDispatcher("/paging.do").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/userDetail.do?userid="+userid);
		}
		
	}
}
