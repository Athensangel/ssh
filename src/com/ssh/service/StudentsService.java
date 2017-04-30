package com.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.Students;

/**
 * 学生Service方法
 */
public interface StudentsService {

	public List<Students> queryAllStudents();//查
	
	public Serializable saveStudents(Students students);//增
	
	public void deleteStudents(Students students);//删
	
	public void updateStudents(Students students);//修改
	
	public Students updateStudentsById(Students students);//查询所有学生信息
}
