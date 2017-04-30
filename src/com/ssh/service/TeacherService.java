package com.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.Teacher;

/**
 * 教师service
 * 
 * @author Administrator
 *
 */
public interface TeacherService {
	public List<Teacher> queryAllTeachers(); // 查询所有的教师

	public Serializable saveTeacher(Teacher teacher);// 查询所有的教师

	public void updateTeacher(Teacher teacher);// 查询所有的教师

	public void deleteTeacher(Teacher teacher);// 查询所有的教师

	public Teacher updateTeacherById(Teacher teacher);// 查询所有的教师
	
}
