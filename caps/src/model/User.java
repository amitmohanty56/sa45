package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable  {
	
	private Long userId;
	private String name;
	private String password;
	private String role;
	
	public User() {

	}
	
	public User(Long userId, String name, String password, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userIdIn) {
		this.userId = userIdIn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String passwordIn) {
		this.password = passwordIn;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String roleIn) {
		this.role = roleIn;
	}

}

