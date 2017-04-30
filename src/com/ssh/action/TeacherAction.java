package com.ssh.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.Teacher;
import com.ssh.entity.User;
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
	/**
	 * 新增所有用户
	 * @return
	 */
	public String saveTeacher(){
		String id=request.getParameter(id);
		String passWord=request.getParameter(passWord);
		String name=request.getParameter(name);
		String sex=request.getParameter(sex);
		String brithday=request.getParameter(brithday);
		String collegeId=request.getParameter(collegeId);
		String post=request.getParameter(passWord);
		String province=request.getParameter(province);
		String city=request.getParameter(city);
		String phone=request.getParameter(phone);
		String title=request.getParameter(title);
		Teacher teacher=new Teacher();
		teacher.setId(id);
		teacher.setPassword(passWord);
		teacher.setName(name);
		teacher.setSex(sex);
		teacher.setBrithday(new Date());
		teacher.setCollegeid(Integer.parseInt(collegeId));
		teacher.setPost(post);
		teacher.setProvince(province);
		teacher.setCity(city);
		teacher.setPhone(phone);
		teacher.setTitle(title);
		teaService.saveTeacher(teacher);
		return "saveTeacher";
		
	}
	
	public  void deleteTeacher();{
		String id=request.getParameter(id);
		Teacher teacher=new Teacher();
		teacher.setId(id);
		teaService.deleteTeacher(teacher);
		return "deleteTeacher"
	}
}
