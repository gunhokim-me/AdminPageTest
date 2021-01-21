package test.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import test.user.service.UserService;
import test.user.service.UserServiceI;
import test.user.vo.UserVo;
import test.util.FileUtil;

@MultipartConfig
@WebServlet("/memRegist.do")
public class MemRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserServiceI service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("userid");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		Part pic = req.getPart("picture");
		String filename = "";
		String realfilename = "";
		
		if(pic.getSize() > 0) {
			filename = FileUtil.getFileName(pic.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			realfilename = UUID.randomUUID().toString() + fileExtension;
			
			pic.write("D:/upload/" + realfilename);
		}
		UserVo vo = new UserVo(id, name, pass, new Date(), alias, addr1, addr2, zipcode, filename, realfilename);
		
		int cnt = 0;
		try {
			cnt = service.registUser(vo);
		} catch (Exception e) {
			cnt = 0;
		}
		
		if(cnt == 1) {
			resp.sendRedirect(req.getContextPath()+"/paging.do");
		}else {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/memberRegist.jsp").forward(req, resp);
		}
	}
		
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("id");
		UserVo vo = service.selectUser(userid);
		int cnt = 0;
		if(vo != null) {
			cnt = 1;
		}else {
			cnt = 0;
		}
		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("/check.jsp").forward(req, resp);
		
	}

}
