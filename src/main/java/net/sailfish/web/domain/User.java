package net.sailfish.web.domain;

public class User {

	private String username;
	private String password;
	private Integer grade;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public User(String username, String password, Integer grade) {
		super();
		this.username = username;
		this.password = password;
		this.grade = grade;
	}

	public User() {
		super();
	}

}
