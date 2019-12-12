package com.pk.entity;

public class ShoppingCart {
	private int id;
	private int goodsid;
	private int userid;
	private int total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodsid;
		result = prime * result + id;
		result = prime * result + total;
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (goodsid != other.goodsid)
			return false;
		if (id != other.id)
			return false;
		if (total != other.total)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", goodsid=" + goodsid + ", userid=" + userid + ", total=" + total + "]";
	}
	public ShoppingCart(int id, int goodsid, int userid, int total) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.userid = userid;
		this.total = total;
	}
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
