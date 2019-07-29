package com.hg.service;

import com.hg.domain.User;

public interface IUserService {
	User loginUser(String accountID, String psd);
}
