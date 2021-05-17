package com.example.EmpApi.model;


import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
	
	@Id
	private String id;
	
	@NotNull(message = "Provide the Name")
	private String name;
	
	private String email;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", Salary="
				+ Salary + ", age=" + age + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String id, @NotNull(message = "Provide the Name") String name, String email, String address,
			int salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		Salary = salary;
		this.age = age;
	}
	private String address;
	private int Salary;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
		
}
