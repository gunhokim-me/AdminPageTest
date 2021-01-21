package test.user.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.user.service.UserService;
import test.user.service.UserServiceI;
import test.user.vo.UserVo;

@WebServlet("/userfile")
public class UserFile extends HttpServlet {
	
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		UserVo vo = service.selectUser(userid);
		String path ="";
		
		if(vo.getRealfilename() == null) {
			path = getServletContext().getRealPath("/profile/unknown.jpg");
		}else {
			path ="d:/upload/" + vo.getRealfilename(); 
		}
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		
		while(fis.read(buff) != -1 ) {
			sos.write(buff);
		}
		
		fis.close();
		sos.close();
	}

}
