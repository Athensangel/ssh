package com.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.User;

/**
 * 用户service
 * @author Administrator
 *
 */
public interface UserService {
	public User login(User user);//登录
	
	public List<User> findUsers();//查
	
	public Serializable saveUser(User user);//增
	
	public void  deleteUser(User user);//删
	
	public void updateUser(User user);//修改
	
	public User findUserById(User user);//修改
	
	
}
