package com.ssh.biz;

import java.util.List;

import com.ssh.entity.Course;

public interface CourseDao {

	// 分页查询
	public List<Course> queryForPage(String hql, int offset, int length);

	// 总记录条数
	public int getCount(String hql);
}
