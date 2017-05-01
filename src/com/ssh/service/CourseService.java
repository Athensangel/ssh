package com.ssh.service;


import com.ssh.entity.PageBean;

public interface CourseService {

	// 分页查询
	public PageBean queryForPage(int pageSize, int page);

	// 总记录条数
	public int getCount();
}
