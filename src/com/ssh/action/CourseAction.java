package com.ssh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.PageBean;
import com.ssh.service.CourseService;

public class CourseAction implements ServletRequestAware{
	HttpServletRequest request;
	private int page;
	private PageBean pageBean;
	private CourseService courseService;

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getCoursePageList() {
		this.pageBean = courseService.queryForPage(6, page);
		request.setAttribute("pageBean", pageBean);
		return "coursePageList";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
