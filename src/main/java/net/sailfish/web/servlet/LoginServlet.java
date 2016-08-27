package net.sailfish.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sailfish.web.UserService;
import net.sailfish.web.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 1、获取用户名
		 * 2、判断用户名中是否包含指定用户
		 * 	- 如果包含，就是管理员
		 * 	- 如果不包含，就是普通会员
		 * 3、把要登录的用户名称保存到session中
		 * 4、转发到index.html
		 */

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		User user = userService.login(username, password);
		if(user != null){
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
