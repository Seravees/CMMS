package com.hg.dao;

import com.hg.domain.User;

public interface IUserDao {
	User find(String accountID, String psd);
}
