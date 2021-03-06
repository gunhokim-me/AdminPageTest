package test.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.user.service.UserService;
import test.user.service.UserServiceI;
import test.user.vo.UserVo;
import test.vo.PageVo;

@WebServlet("/paging.do")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageparam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		String type = req.getParameter("type");
		String search = req.getParameter("search");
		PageVo vo = new PageVo();
		List<UserVo> list = new ArrayList<UserVo>();
		
		//페이징 처리
		int page = pageparam == null? 1 :  Integer.parseInt(pageparam) ;
		int pageSize = 5;
		if(pageSizeParam == null) {
			pageSize = 5;
		}else if(pageSizeParam.equals("")) {
			pageSize = 5;
		}else  {
			pageSize = Integer.parseInt(pageSizeParam);
		}
//		int pageSize = pageSizeParam == null? 5 :  Integer.parseInt(pageSizeParam) ;
		
		vo.setPage(page);
		vo.setPageSize(pageSize);
		
		//분류에 따른 검색
		Map<String, Object> map = new HashMap<String, Object>();
		if(type == null || type.equals("")) {
			map = userService.selectPagingUser(vo);
		}else if(type.equals("i")) {
			vo.setVal(search+"%");
			map = userService.idFindUser(vo);
		}else if(type.equals("n")) {
			vo.setVal(search+"%");
			map = userService.nameFindUser(vo);
		}else if(type.equals("a")) {
			vo.setVal(search+"%");
			map = userService.aliasFindUser(vo);
		}else {
			map = userService.selectPagingUser(vo);
		}
		
		int startpage = 0;
		int endpage = 0;
		
		if(page-4 <= 1) {
			startpage = 1;
		}else {
			
		}
		
		//결과값 scope에 넣고 날리기
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double)userCnt /pageSize);
		
		list = (List<UserVo>) map.get("userList");
		if(list != null) {
			req.setAttribute("userList", list);
		}
		
		req.setAttribute("type", type);
		req.setAttribute("pagesize", pageSizeParam);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pageVo", vo);
		req.getRequestDispatcher("/memberList.jsp").forward(req, resp);
	}

}
