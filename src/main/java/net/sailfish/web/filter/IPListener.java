package net.sailfish.web.filter;

import java.util.LinkedHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IPListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent evt) {
    	/*
    	 * 在ServletContext被创建后，就把map保存到ServletContext中
    	 * 这就保证了在Filter中获取ServletContext中的map，一定会获取到！！！
    	 */
    	/*
    	 * 1. 得到ServletContext
    	 * 2. 创建map，并保存
    	 */
    	evt.getServletContext().setAttribute("map", new LinkedHashMap<String,Integer>());
    }

    public void contextDestroyed(ServletContextEvent evt) {
    }
}
