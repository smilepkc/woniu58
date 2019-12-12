package com.pk.entity;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer id;
	private String ordernumber;
	private String paynumber;
	private Integer state;
	private Date createtime;
	private Integer userid;
	private Integer addressid;
	private Integer flag;
	
	// �����һ����Ա���������ڴ洢һ�������µ����еĶ�������
	private List<OrderItem> ois;

	
	public List<OrderItem> getOis() {
		return ois;
	}

	public void setOis(List<OrderItem> ois) {
		this.ois = ois;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getPaynumber() {
		return paynumber;
	}

	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressid == null) ? 0 : addressid.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ois == null) ? 0 : ois.hashCode());
		result = prime * result + ((ordernumber == null) ? 0 : ordernumber.hashCode());
		result = prime * result + ((paynumber == null) ? 0 : paynumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		Order other = (Order) obj;
		if (addressid == null) {
			if (other.addressid != null)
				return false;
		} else if (!addressid.equals(other.addressid))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ois == null) {
			if (other.ois != null)
				return false;
		} else if (!ois.equals(other.ois))
			return false;
		if (ordernumber == null) {
			if (other.ordernumber != null)
				return false;
		} else if (!ordernumber.equals(other.ordernumber))
			return false;
		if (paynumber == null) {
			if (other.paynumber != null)
				return false;
		} else if (!paynumber.equals(other.paynumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", ordernumber=" + ordernumber + ", paynumber=" + paynumber + ", state=" + state
				+ ", createtime=" + createtime + ", userid=" + userid + ", addressid=" + addressid + ", flag=" + flag
				+ ", ois=" + ois + "]";
	}

	public Order(Integer id, String ordernumber, String paynumber, Integer state, Date createtime, Integer userid,
			Integer addressid, Integer flag) {
		super();
		this.id = id;
		this.ordernumber = ordernumber;
		this.paynumber = paynumber;
		this.state = state;
		this.createtime = createtime;
		this.userid = userid;
		this.addressid = addressid;
		this.flag = flag;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}

