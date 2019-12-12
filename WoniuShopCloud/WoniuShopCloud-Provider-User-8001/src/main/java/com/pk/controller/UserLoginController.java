package com.pk.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pk.entity.LoginRegisterReturn;
import com.pk.entity.User;
import com.pk.service.UserService;
import com.zhenzi.sms.ZhenziSmsClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		//查询的逻辑，最终获取到user的数据
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		User user = userService.findOne(account);
		if(user.getId()==null) {
			String str="用户名不存在";
			LoginRegisterReturn data=new LoginRegisterReturn(str,"false");
			JSONObject acobj = JSONObject.fromObject(data);
			return acobj.toString();
		}else {
			if(req.getParameter("ValidCode").equals("")) {
				String str="请输入验证码~";
				LoginRegisterReturn data=new LoginRegisterReturn(str,"false");
				JSONObject validobj = JSONObject.fromObject(data);
				return validobj.toString();
			}else {
				String validCode=req.getParameter("ValidCode");
				String code=req.getSession().getAttribute("ValidCode").toString();
				if(!validCode.equalsIgnoreCase(code)) {
					String str="验证码输入错误";
					LoginRegisterReturn data=new LoginRegisterReturn(str,"false");
					JSONObject validobj = JSONObject.fromObject(data);
					return validobj.toString();
				}else {
					if(user.getPassword().equals(password)) {
						req.getSession().setAttribute("user",user);
						LoginRegisterReturn data=new LoginRegisterReturn(user.getAccount(),"true");
						JSONObject acobj = JSONObject.fromObject(data);
						return acobj.toString();
						
					}else {
						String str="账号密码输入错误,请重新登陆";
						LoginRegisterReturn data=new LoginRegisterReturn(str,"false");
						JSONObject failedobj = JSONObject.fromObject(data);
						return failedobj.toString();
					}
				}
			}
			
		}
	}
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest req,HttpServletResponse resp,User user) {
		//查询的逻辑，最终获取到user的数据
		String account = req.getParameter("account");
		String password=req.getParameter("password");
		String uverifyCode =req.getParameter("verifyCode");
		User reguser = userService.findOne(account);
		if(uverifyCode.equalsIgnoreCase(req.getSession().getAttribute("verifyCode").toString())) {
			if(reguser.getAccount()==null) {
				User user2 =new User();
				user2.setAccount(account);
				user2.setPassword(password);
				user2.setRoleid(1);
				user2.setFlag(0);
				userService.insertOne(user2);
				LoginRegisterReturn data=new LoginRegisterReturn("注册成功","true");
				JSONObject obj = JSONObject.fromObject(data);
				return obj.toString();
			}else {
				LoginRegisterReturn data=new LoginRegisterReturn("注册失败,用户名已存在","false");
				JSONObject obj = JSONObject.fromObject(data);
				return obj.toString();
			}
		}else {
			LoginRegisterReturn data=new LoginRegisterReturn("验证码输入错误","false");
			JSONObject obj = JSONObject.fromObject(data);
			return obj.toString();
		}
		
	}
	@RequestMapping(value = "/loginstate")
	public LoginRegisterReturn loginState(HttpServletRequest req,HttpServletResponse resp) {
		User user=(User) req.getSession().getAttribute("user");
		if(user==null) {
			return new LoginRegisterReturn("用户没有登录","false");
		}else {
			return new LoginRegisterReturn(user.getAccount(),"true");
		}
	}
	@RequestMapping(value = "/loginout")
	public void loginout(HttpServletRequest req,HttpServletResponse resp) {
		req.getSession().removeAttribute("user");
		ServletContext sc = req.getServletContext();
		String contextPath = sc.getContextPath();
		try {
			resp.sendRedirect(contextPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int count=0;
	@RequestMapping(value="/reload")
	public HashMap<String,Object> reload() {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("count",count);
		count++;
		return map;
	}
	@RequestMapping(value="/SendVerifyCode")
	public String registerVerifyCode(HttpServletRequest req){
		HashMap<String,Object> map=new HashMap<String, Object>();
		String account = req.getParameter("account");
		String apiUrl="https://sms_developer.zhenzikj.com";
		String appId="103071";
		String appSecret="aeb92651-e154-462b-82ca-c87ef673c26a";
		ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
		String result="";
		try {
			String[] beforeShuffle = new String[] { "0","1","2", "3", "4", "5", "6", "7", 
		             "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
		             "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
		             "W", "X", "Y", "Z" }; 
		     List list = Arrays.asList(beforeShuffle); 
		     Collections.shuffle(list); 
		     StringBuilder sb = new StringBuilder(); 
		     for (int i = 0; i < list.size(); i++) { 
		         sb.append(list.get(i)); 
		     } 
		     String afterShuffle = sb.toString(); 
		     String result1 = afterShuffle.substring(5, 9); 
		result = client.send(account, "woniushop:您的验证码为"+result1);
		req.getSession().setAttribute("verifyCode",result1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
