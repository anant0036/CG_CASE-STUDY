package com.example.GuestApi.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.example.GuestApi.exception.GuestCollectionException;
import com.example.GuestApi.model.Guest;

public interface GuestService {

	public List<Guest> getAllGuest();
	
	public void createGuest(Guest guest) throws ConstraintViolationException, GuestCollectionException;

	public Guest getSingleGuest(String id) throws GuestCollectionException;

	public void updateGuest(String id, Guest guest) throws GuestCollectionException;

	public void deleteGuest(String id) throws GuestCollectionException;
	
}
