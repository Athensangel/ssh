package com.ssh.biz.impl;



import com.ssh.biz.UserDao;
import com.ssh.entity.User;

public class UserDaoImpl implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User checkLogin(User user) {
		String hql = "from User a where a.userName = ? and a.passWord = ?";
		//List<User> list = this.getSessionFactory().getCurrentSession().createQuery(hql).list();
		return null;
	}

}
