package com.hg.service;

import java.util.List;

import com.hg.domain.User;

public interface IUserService {
	User loginUser(String accountID, String psd);

	List<User> getUsers();

	List<User> searchUser(String name);

	int addUser(User user);
	
	int editUser(String accountID, User user);
	
	int deleteUser(String accountID);
}
