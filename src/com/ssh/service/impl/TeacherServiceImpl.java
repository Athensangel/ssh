package com.ssh.service.impl;

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

}
