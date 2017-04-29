package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ssh.biz.BaseDao;
import com.ssh.entity.User;
import com.ssh.service.UserService;
/**
 * 用户service实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {
	private BaseDao<User> bDao;

	public BaseDao<User> getbDao() {
		return bDao;
	}

	public void setbDao(BaseDao<User> bDao) {
		this.bDao = bDao;
	}

	@Override
	public User login(User user) {
		return bDao.get("from User a where a.userName=? and a.passWord=?", new Object[]{user.getUserName(),user.getPassWord()});
	}

	@Override
	public List<User> findUsers() {
		return bDao.find("from User");
	}

	@Override
	public Serializable saveUser(User user) {
		return bDao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		bDao.delete(user);
	}

	@Override
	public void updateUser(User user) {
		bDao.update(user);
	}

	@Override
	public User findUserById(User user) {
		User u = bDao.get(User.class, user.getId());
		return u;
	}

}
