package com.example.demo.model;

public class UserModel {
	private int user_id;
	private String user_name;
	private String user_job;
	
	
	public UserModel() {
		super();
	}
	public UserModel(int user_id, String user_name, String user_job) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_job = user_job;
	}
	
	public UserModel(String user_name, String user_job) {
		super();
		this.user_name = user_name;
		this.user_job = user_job;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	@Override
	public String toString() {
		return "UserModel [user_id=" + user_id + ", user_name=" + user_name + ", user_job=" + user_job + "]";
	}
	
	
	
}
