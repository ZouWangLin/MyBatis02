package com.itheima.entity;

public class OrdersUser extends Orders{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "Orders [id=" + super.getId() + ", userId=" + super.getUserId() + ", number=" + super.getNumber() + 
				", createtime=" + super.getCreatetime()
				+ ", note=" + super.getNote()  +",username="+username
				+",address="+address
				+"]";
	}
	
	
	

}
