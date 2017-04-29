package com.ssh.service;

import java.util.List;

import com.ssh.entity.Teacher;
/**
 * 教师service
 * @author Administrator
 *
 */
public interface TeacherService {
	public List<Teacher> queryAllTeachers();  //查询所有的教师
}
