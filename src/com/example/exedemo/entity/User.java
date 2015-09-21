package com.example.exedemo.entity;

import com.example.exedemo.ExeApplication;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "User")
public class User {
	
	public enum SEX{
		MAN(0),WOMEN(1);
		
		public int value;
		
		private SEX(int value){
			this.value = value;
		}
	}
	
	public enum ROLE{
		TEACHER(0),STUDENT(1);
		
		public int value;
		
		private ROLE(int value){
			this.value = value;
		}
	}
	
	private int id;
	private String name;
	private String pwd;
	private boolean isALogin;
	private int age;
	private int sex;
	private int role;
	
	public User(){}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isALogin() {
		return isALogin;
	}

	public void setALogin(boolean isALogin) {
		this.isALogin = isALogin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public void save(){
		try {
			ExeApplication.getDbUtils().saveOrUpdate(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
