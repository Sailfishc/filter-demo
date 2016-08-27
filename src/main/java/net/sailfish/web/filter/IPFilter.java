package net.sailfish.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 分IP统计访问次数
 *
 */
public class IPFilter implements Filter {
	private FilterConfig config;
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * 1. 得到map
		 * 2. 得到ip
		 * 3. 得到次数
		 * 4. 把ip为key，次数为value，保存到map中！
		 * 5. 放行！
		 */
		/*
		 * 1. 得到map
		 *   * 得到FilterConfig
		 *   * 得到ServletContext
		 *   * 得到Map
		 */
		Map<String,Integer> map = (Map<String, Integer>) this.config
				.getServletContext().getAttribute("map");
		
		/*
		 * 2. 得到IP
		 */
		String ip = request.getRemoteAddr();
		/*
		 * 3. 得到次数
		 */
		if(map.containsKey(ip)) {//原来就包含这个ip的统计
			int cnt = map.get(ip) + 1;//获取原统计，再加1
			map.put(ip, cnt);
		} else {//原来没有这个ip的统计
			map.put(ip, 1);
		}
		
		/*
		 * 4. 放行
		 */
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
