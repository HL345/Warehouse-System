package com.lrfNetwork.Info;

public class User {
	
	public User(Integer id, String username, String password, String email, Integer is_admin, String reg_date) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.is_admin = is_admin;
		this.reg_date = reg_date;
	}
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer is_admin;
	private String reg_date;
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Integer getIs_admin() {
		return is_admin;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIs_admin(Integer is_admin) {
		this.is_admin = is_admin;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
