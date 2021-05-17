package com.example.reservation.model;


import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reservation")
public class Reservation 
{

//    Code, Number of children, Number of adults, check-in date, check out date, status, Number of nights
    @Id
    private String id;
    private String name;
    private String noChild;
    private String noAdult;
    private String noNight;
    private String checkIn;
    private String CheckOut;
    
    
    
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", name=" + name + ", noChild=" + noChild + ", noAdult=" + noAdult
				+ ", noNight=" + noNight + ", checkIn=" + checkIn + ", CheckOut=" + CheckOut + "]";
	}
	public Reservation() {
		super();
	}
	public Reservation(String id, String name, String noChild, String noAdult, String noNight, String checkIn,
			String checkOut) {
		super();
		this.id = id;
		this.name = name;
		this.noChild = noChild;
		this.noAdult = noAdult;
		this.noNight = noNight;
		this.checkIn = checkIn;
		CheckOut = checkOut;
	}
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
	public String getNoChild() {
		return noChild;
	}
	public void setNoChild(String noChild) {
		this.noChild = noChild;
	}
	public String getNoAdult() {
		return noAdult;
	}
	public void setNoAdult(String noAdult) {
		this.noAdult = noAdult;
	}
	public String getNoNight() {
		return noNight;
	}
	public void setNoNight(String noNight) {
		this.noNight = noNight;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}
    


}
