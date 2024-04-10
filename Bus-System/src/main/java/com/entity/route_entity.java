package com.entity;

public class route_entity 
{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private  String stop_no;
	private String stop_name;
	private String driver_name;
	private String name;
	
	private byte[] pic;
	private byte[] pic1;
	
	public byte[] getPic1() {
		return pic1;
	}
	public void setPic1(byte[] pic1) {
		this.pic1 = pic1;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public String getStop_no() {
		return stop_no;
	}
	public void setStop_no(String stop_no) {
		this.stop_no = stop_no;
	}
	public String getStop_name() {
		return stop_name;
	}
	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private String address;
	private String phone;
	private String dept;
	private String course;

}
