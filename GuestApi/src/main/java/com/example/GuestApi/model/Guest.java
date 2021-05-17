package com.example.GuestApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "guest")
public class Guest {

	@Id
	private String id;

	@NotNull(message = "Provide the Name")
	private String name;
	private String email;
	private String gender;
	private String address;
	private String govId;
	private String phonenumber;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGovId() {
		return govId;
	}
	public void setGovId(String govId) {
		this.govId = govId;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Guest(String id, @NotNull(message = "Provide the Name") String name, String email, String gender,
			String address, String govId, String phonenumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.govId = govId;
		this.phonenumber = phonenumber;
	}
	public Guest() {
		super();
	}
	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", address=" + address
				+ ", govId=" + govId + ", phonenumber=" + phonenumber + "]";
	}
	
	
	
	
	
}
