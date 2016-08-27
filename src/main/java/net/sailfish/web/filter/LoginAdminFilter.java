package net.sailfish.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.sailfish.web.domain.User;

/**
 * Servlet Filter implementation class LoginAdminFilter
 */
public class LoginAdminFilter implements Filter {

	public void destroy() {
	}

	/**
	 * 拦截登陆
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User) req.getSession().getAttribute("user");
		if(user == null){
			response.getWriter().print("您还没有登陆");
			return ;
		}
		
		if(user.getGrade() < 2){
			response.getWriter().print("您的等级不够");
			return ;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
