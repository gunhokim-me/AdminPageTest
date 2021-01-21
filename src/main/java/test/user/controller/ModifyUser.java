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
@WebServlet("/modify.do")
public class ModifyUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserVo vo = new UserVo();
		String userid = req.getParameter("userid");
		vo = service.selectUser(userid);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/memberDetail.jsp").forward(req, resp);
	}
	
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
		
		Part userfile =req.getPart("picture");
		String filename="";
		String realfilename="";
		UserVo vo = new UserVo(id, name, pass, new Date(), alias, addr1, addr2, zipcode, filename, realfilename);
		
		if(userfile.getSize() > 0) {
			filename =FileUtil.getFileName(userfile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			realfilename = UUID.randomUUID().toString() + fileExtension;
			
			userfile.write("D:/upload/" + realfilename);
			vo.setFilename(realfilename);
			vo.setRealfilename(realfilename);
		}else {
			UserVo vo2 = new UserVo();
			vo2 = service.selectUser(id);
			vo.setFilename(vo2.getFilename());
			vo.setRealfilename(vo2.getRealfilename());
		}
		
		int cnt = service.modifyUser(vo);
		if(cnt == 1) {
			resp.sendRedirect(req.getContextPath() + "/userDetail.do?userid=" + id);
		}else {
			doGet(req, resp);
		}
		
		
		
		
		
		
	}

}
