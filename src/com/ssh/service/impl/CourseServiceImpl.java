package com.ssh.service.impl;

import java.util.List;

import com.ssh.biz.CourseDao;
import com.ssh.entity.Course;
import com.ssh.entity.PageBean;
import com.ssh.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public PageBean  queryForPage(int pageSize, int page) {
		String hql = "select count(*) from Course";
		int count = courseDao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List< Course> list = courseDao.queryForPage("from Course", offset, length); // 该分页的记录
		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	@Override
	public int getCount() {
		return 0;
	}

}
