package com.pk.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.entity.User;
import com.pk.service.CommonUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private CommonUserService commonUserService;
	@RequestMapping("/login")
	public String login(HttpServletResponse resp,HttpServletRequest req) {
		return commonUserService.login(resp,req);
	}
	
	@RequestMapping(value = "/register")
	public String register(User user) {
		return commonUserService.register(user);
	}
	
	@RequestMapping(value = "/loginstate")
	public String loginState() {
		return commonUserService.loginState();
	}
	@RequestMapping(value = "/provider/loginout")
	public void loginout() {
		commonUserService.loginout();
	}
	public static int count=0;
	
	@RequestMapping(value="/reload")
	public HashMap<String,Object> reload() {
		return commonUserService.reload();
	}
	
	@RequestMapping(value="/SendVerifyCode")
	public String registerVerifyCode() {
		return commonUserService.registerVerifyCode();
	}
}
