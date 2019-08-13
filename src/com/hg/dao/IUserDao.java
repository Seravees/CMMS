package com.hg.dao;

import java.util.List;

import com.hg.domain.User;

public interface IUserDao {
	User find(String accountID, String psd);

	List<User> findAllUser();

	List<User> searchUser(String name);

	int addUser(User user);

	int editUser(String accountID, User user);
	
	int deleteUser(String accountID);
}
