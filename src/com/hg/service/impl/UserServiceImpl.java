package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IUserDao;
import com.hg.dao.impl.UserDaoImpl;
import com.hg.domain.User;
import com.hg.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User loginUser(String accountID, String psd) {
		// TODO Auto-generated method stub
		return userDao.find(accountID, psd);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public List<User> searchUser(String name) {
		// TODO Auto-generated method stub
		return userDao.searchUser(name);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public int editUser(String accountID, User user) {
		// TODO Auto-generated method stub
		return userDao.editUser(accountID, user);
	}

	@Override
	public int deleteUser(String accountID) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(accountID);
	}
}
