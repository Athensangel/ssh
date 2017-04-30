package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ssh.biz.BaseDao;
import com.ssh.entity.Teacher;
import com.ssh.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private BaseDao<Teacher> bDao;

	public BaseDao<Teacher> getbDao() {
		return bDao;
	}

	public void setbDao(BaseDao<Teacher> bDao) {
		this.bDao = bDao;
	}
	
	@Override
	public List<Teacher> queryAllTeachers() {
		return bDao.find("from Teacher");
	}

	@Override
	public Serializable saveTeacher(Teacher techer) {
		return bDao.save(techer);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		bDao.update(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		bDao.delete(teacher);
	}

	@Override
	public Teacher updateTeacherById(Teacher teacher) {
		Teacher t=bDao.get(Teacher.class,teacher.getId());
		return t;
	}

}
