package com.pk.entity;

public class LoginRegisterReturn {

	
	private String msg;//��ʾ��Ϣ
	private String flag;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public LoginRegisterReturn(String msg, String flag) {
		super();
		this.msg = msg;
		this.flag = flag;
	}
	
}
