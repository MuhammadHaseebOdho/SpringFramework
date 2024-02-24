package com.spring.jdbc.model;

public class Student {

	private Integer id;
	private String name;
	private String rollNumber;
	private String department;
	private Integer age;
	
	
	public Student() {

	}
	public Student(Integer id, String name, String rollNumber, String department, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.rollNumber = rollNumber;
		this.department = department;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNumber=" + rollNumber + ", department=" + department
				+ ", age=" + age + "]";
	}
	
	
	
	
	
}
