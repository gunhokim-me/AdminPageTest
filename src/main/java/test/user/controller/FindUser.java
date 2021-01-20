//package test.user.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import test.user.service.UserService;
//import test.user.service.UserServiceI;
//import test.user.vo.UserVo;
//
//@WebServlet("/search.do")
//public class FindUser extends HttpServlet{
//	private static final long serialVersionUID = 1L;
//	
//	private UserServiceI service = new UserService();
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String type = req.getParameter("type");
//		String search = req.getParameter("search");
//		List<UserVo> list = new ArrayList<UserVo>();
//		
//		if(type.equals("i")) {
//			list = service.idFindUser(search);
//		}else if(type.equals("n")) {
//			list = service.nameFindUser(search);
//		}else if(type.equals("a")) {
//			list = service.aliasFindUser(search);
//		}else {
//			list = service.allUserList();
//		}
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/paging.do").forward(req, resp);
//	}
//}
