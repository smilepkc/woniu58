package com.pk.service;

import com.pk.entity.User;

public interface UserService {

	User findOne(String account);
	void insertOne(User user);
}
