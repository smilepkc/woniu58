package com.pk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.dao.UserDao;
import com.pk.entity.User;
import com.pk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	public User findOne(String account) {
		return dao.findOne(account);
	}

	public void insertOne(User user) {
		dao.insertOne(user);
	}
}
