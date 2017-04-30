package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ssh.biz.BaseDao;
import com.ssh.entity.Students;
import com.ssh.service.StudentsService;

public class StudentsServiceImpl implements StudentsService {

	private BaseDao<Students> sDao;

	public BaseDao<Students> getsDao() {
		return sDao;
	}

	public void setsDao(BaseDao<Students> sDao) {
		this.sDao = sDao;
	}

	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		return sDao.find("from Students");
	}

	@Override
	public Serializable saveStudents(Students students) {
		return sDao.save(students);
	}

	@Override
	public void deleteStudents(Students students) {
		sDao.delete(students);
	}

	@Override
	public void updateStudents(Students students) {
		sDao.update(students);
	}

	@Override
	public Students updateStudentsById(Students students) {
		Students s=sDao.get(Students.class,students.getId());
		return s;
	}
}
