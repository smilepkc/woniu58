package com.pk.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dsna.util.images.ValidateCode;


@Controller
@RequestMapping("/Valid")
public class ValiddCodeController {
	@RequestMapping("/getValidCode")
	public void getVaildCode(HttpServletRequest req,HttpServletResponse resp) {
		ValidateCode code=new ValidateCode(120, 60, 4, 10);
		String ValidCode=code.getCode();
		req.getSession().setAttribute("ValidCode", ValidCode);
		resp.setContentType("image/jpg");
		try {
			code.write(resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
