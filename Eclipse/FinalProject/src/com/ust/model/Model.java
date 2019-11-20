package com.ust.model;

public class Model {
	//Instance variable of login table
	private int userId;
	private String username;
	private String password;
	
	//INstance variable of vendor table
	private int vId;
	private String vName;
	private String address;
	private String location;
	private String service;
	private String pincode;
	private String vIsActive;
	
	//Instance variable of contact table
	private int cId;
	private String cName;
	private String department;
	private String email;
	private String phone;
	private String cIsActive;
	
	//Getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getvIsActive() {
		return vIsActive;
	}
	public void setvIsActive(String vIsActive) {
		this.vIsActive = vIsActive;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getcIsActive() {
		return cIsActive;
	}
	public void setcIsActive(String cIsActive) {
		this.cIsActive = cIsActive;
	}
	
	//Default constructor
	public Model() {
		super();
	}
	
	//Parameterized constructor without all fields
	public Model(String username, String password, int vId, String vName,
			String address, String location, String service, String pincode,
			String vIsActive, String cName, String department, String email,
			String phone, String cIsActive) {
		super();
		this.username = username;
		this.password = password;
		this.vId = vId;
		this.vName = vName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.vIsActive = vIsActive;
		this.cName = cName;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.cIsActive = cIsActive;
	}
	
	//Parameterized constructor with all fields
	public Model(int userId, String username, String password, int vId,
			String vName, String address, String location, String service,
			String pincode, String vIsActive, int cId, String cName,
			String department, String email, String phone, String cIsActive) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.vId = vId;
		this.vName = vName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.vIsActive = vIsActive;
		this.cId = cId;
		this.cName = cName;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.cIsActive = cIsActive;
	}
	
	//Tostring
	@Override
	public String toString() {
		return "Model [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", vId=" + vId + ", vName="
				+ vName + ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", vIsActive=" + vIsActive + ", cId=" + cId + ", cName="
				+ cName + ", department=" + department + ", email=" + email
				+ ", phone=" + phone + ", cIsActive=" + cIsActive + "]";
	}
	
	

}
