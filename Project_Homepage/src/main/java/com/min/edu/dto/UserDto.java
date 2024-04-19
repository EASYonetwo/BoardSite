package com.min.edu.dto;

public class UserDto {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String joindate;
	private String auth;
	private String enabled;
	public UserDto() {}
	public UserDto(String id, String password, String name, String address, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", joindate=" + joindate + ", auth=" + auth + ", enabled=" + enabled + "]";
	}
}
