package com.pk.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.pk.entity.User;

public interface UserDao {
	@Select("select *from user where account=#{account}")
	User findOne(String account);
	@Insert("insert into user(account,password,roleid,flag) values(#{account},#{password},#{roleid},#{flag})")
	void insertOne(User user);
}
