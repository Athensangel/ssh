package com.ssh.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.Students;
import com.ssh.service.StudentsService;

public class StudentsAction implements ServletRequestAware{
  HttpServletRequest request;
  
  private StudentsService studService;

public StudentsService getStudService() {
	return studService;
}

public void setStudService(StudentsService studService) {
	this.studService = studService;
}

public HttpServletRequest getRequest() {
	return request;
}

public void setRequest(HttpServletRequest request) {
	this.request = request;
}
/**
 * 查询所有用户
 * @return
 */
public String findAllStudents(){
	List<Students> studentsList = studService.queryAllStudents();
	request.setAttribute("studentsList", studentsList);
	return "findAllstudent";
}
/**
 * 新增所有用户
 * @return
 */
public String addStudents(){
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String telPhone = request.getParameter("telPhone");
	String eMail = request.getParameter("eMail");
	Students students=new Students();
	students.setId(getUUID());
	students.setName(name);
	students.setAge(age);
	students.setTelPhone(telPhone);
	students.seteMail(eMail);
	studService.saveStudents(students);
	return "saveStudent";
}
/**
 * 获得一个UUID 
 * @return
 */
public String getUUID() {
	  String s = UUID.randomUUID().toString(); 
      //去掉“-”符号 
      return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
}

/**
 *删除一条数据 
 * @return
 */

public String deleteStudents(){
	 String id = request.getParameter("id");
	 Students students = new Students();
	 students.setId(id);		 
	 studService.deleteStudents(students);
	 return "deleteStudents";
}
/**
 *跳转到新增页
 * @return
 */
public String jumpStudentsAdd(){
	return "jumpStudentsAdd";
}

/**
 *修改页面
 * @return
 */
public String updateStudents(){
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String telPhone = request.getParameter("telPhone");
	String eMail = request.getParameter("eMail");
	Students students=new Students();
	students.setId(id);
	students.setName(name);
	students.setAge(age);
	students.setTelPhone(telPhone);
	students.seteMail(eMail);
	studService.updateStudents(students);
	return "updateStudents";
}
/**
 * 跳转到修改页面
 * @return
 */
public String jumpStudnetsUpdate(){
	String id = request.getParameter("id");
	Students students = new Students();
	students.setId(id);
	Students currentStudnets = studService.updateStudentsById(students);
	request.setAttribute("currentStudnets", currentStudnets);
	return "jumpStudentsUpdate";
}

@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
}
}
