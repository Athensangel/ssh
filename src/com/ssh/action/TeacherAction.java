package com.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.Teacher;
import com.ssh.service.TeacherService;


public class TeacherAction implements ServletRequestAware{
	HttpServletRequest request;
	private TeacherService teaService;
	
	public TeacherService getTeaService() {
		return teaService;
	}

	public void setTeaService(TeacherService teaService) {
		this.teaService = teaService;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	/**
	 * 查询所有用户
	 * @return
	 */
	public String findAllTeachers(){
		List<Teacher> teacherList = teaService.queryAllTeachers();
		request.setAttribute("teacherList", teacherList);
		return "findTeachers";
	}
	
	

}
