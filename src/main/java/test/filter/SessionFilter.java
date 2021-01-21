package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.user.vo.UserVo;

public class SessionFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		String uri = req.getRequestURI();
		
		if(uri.endsWith("login.jsp") || uri.endsWith("login.do")|| uri.contains("/css/") || uri.contains("/profile/") || uri.contains("/js/")) {
			chain.doFilter(request, response);
		}else {
			UserVo vo =(UserVo) req.getSession().getAttribute("S_USER");
			
			if(vo == null) {
				((HttpServletResponse)response).sendRedirect("/test/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
	}
	
	@Override
	public void destroy() {
	}
}
