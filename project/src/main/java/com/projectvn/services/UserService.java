package com.projectvn.services;

import com.projectvn.models.User;

public interface UserService {
	User findByUserName(String userName);
}
