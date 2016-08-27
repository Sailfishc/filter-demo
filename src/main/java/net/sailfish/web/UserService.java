package net.sailfish.web;

import java.util.HashMap;
import java.util.Map;

import net.sailfish.web.domain.User;

public class UserService {
	
	private static Map<String, User> users = new HashMap<String, User>();
	static{
		users.put("zhang", new User("zhang", "111", 1));
		users.put("li", new User("li", "111", 2));
	}
	
	
	public User login(String username, String password){
		User user = users.get(username);
		if(user == null){
			return null;
		}
		
		return user.getPassword().equals(password) ? user : null;
	}
}
