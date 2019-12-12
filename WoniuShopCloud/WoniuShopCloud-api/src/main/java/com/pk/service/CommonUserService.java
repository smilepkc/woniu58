package com.pk.service;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pk.entity.User;
@FeignClient(name = "WONIUSHOPCLOUD-PROVIDER-USER-8001")
public interface CommonUserService {
	@RequestMapping("/provider/login")
	public String login(HttpServletResponse resp,HttpServletRequest req);
	
	@RequestMapping(value = "/provider/register")
	public String register(User user);
	
	@RequestMapping(value = "/provider/loginstate")
	public String loginState();
	public static int count=0;
	
	@RequestMapping(value = "/provider/loginout")
	public void loginout();
	
	@RequestMapping(value="/provider/reload")
	public HashMap<String,Object> reload();
	
	@RequestMapping(value="/provider/SendVerifyCode")
	public String registerVerifyCode();
}
