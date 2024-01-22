package com.entity;

public class Users {
	private int id;
	

	private String name;
	private String email;
	private String password;
	
	public Users( String name,String email,String password) {
		super();
		this.name=name;
		this.email=email;
		this.password=password;
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", password=" + password +"]";
	}
	

}
