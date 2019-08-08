package com.hg.service;

import java.util.List;

import com.hg.domain.User;

public interface IUserService {
	User loginUser(String accountID, String psd);
	
	List<User> getUsers();
	
	User searchUser(String name);
}
