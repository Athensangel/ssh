package com.ssh.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	/**
	 * 新增所有用户
	 * @return
	 */
	public String saveTeacher(){
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String brithday = request.getParameter("brithday");
		String collegeid = request.getParameter("collegeid");
		String post = request.getParameter("post");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String title = request.getParameter("title");
		Teacher teacher = new Teacher();
		teacher.setId(getUUID());
		teacher.setPassword(password);
		teacher.setName(name);
		teacher.setSex(sex);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = sdf.parse(brithday);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		teacher.setBrithday(date);
		teacher.setCollegeid(Integer.parseInt(collegeid));
		teacher.setPost(post);
		teacher.setProvince(province);
		teacher.setCity(city);
		teacher.setPhone(phone);
		teacher.setTitle(title);
		teaService.saveTeacher(teacher);
		return "saveTeacher";
		
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	public  String jumpTeacherAdd(){
		return "jumpTeacherAdd";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String jumpTeacherUpdate(){
		String id = request.getParameter("id");
		Teacher teacher = new Teacher();
		teacher.setId(id);
		Teacher currentTeacher = teaService.updateTeacherById(teacher);
		request.setAttribute("currentTeacher", currentTeacher);
		return "jumpTeacherUpdate";
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	
	
	
	public String updateTeacher(){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String brithday = request.getParameter("brithday");
		String collegeid = request.getParameter("collegeid");
		String post = request.getParameter("post");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String title = request.getParameter("title");
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setPassword(password);
		teacher.setName(name);
		teacher.setSex(sex);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = sdf.parse(brithday);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		teacher.setBrithday(date);
		teacher.setCollegeid(Integer.parseInt(collegeid));
		teacher.setPost(post);
		teacher.setProvince(province);
		teacher.setCity(city);
		teacher.setPhone(phone);
		teacher.setTitle(title);
		teaService.updateTeacher(teacher);
		return "updateTeacher";
	}
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteTeacher(){
		String id = request.getParameter("id");
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teaService.deleteTeacher(teacher);
		return "deleteTeacher";
	}
	
	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }
	
}
