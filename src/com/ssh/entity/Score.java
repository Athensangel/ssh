package com.ssh.entity;

public class Score {
   private String id;
   private Integer score;
   private String courseId;
   private String stuId;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getStuId() {
	return stuId;
}
public void setStuId(String stuId) {
	this.stuId = stuId;
}
@Override
public String toString() {
	return "Score [id=" + id + ", score=" + score + ", courseId=" + courseId + ", stuId=" + stuId + "]";
}
   
   
}
