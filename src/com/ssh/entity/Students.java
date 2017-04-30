package com.ssh.entity;
/**
 * 学生实体类
 * @author cc
 *
 */
public class Students {
	private String id;
	
	private String name;//学生姓名
	
	private String age;//学生年龄
	
	private String telPhone;//学生电话号码
	
	private String eMail;//学生电子邮箱

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", age=" + age + ", telPhone=" + telPhone + ", eMail=" + eMail
				+ "]";
	}
	
}
