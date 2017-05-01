package com.ssh.entity;

/**
 * 课程
 * @author Administrator
 *
 */
public class Course {
	private String cno;//课程代码（主键）
	private String cname;//课程名称
	private String cpno;//选修课程
	private String credit;//学分
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpno() {
		return cpno;
	}
	public void setCpno(String cpno) {
		this.cpno = cpno;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}

}
