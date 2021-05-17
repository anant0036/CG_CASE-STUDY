package com.example.GuestApi.exception;

public class GuestCollectionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuestCollectionException(String message)
	{
		super(message);
	}
	
	public static String NotFoundException(String id)
	{
		return "Guest with "+id+" not found!";
	}
	
	public static String GuestAlreadyExists()
	{
		return "Guest with given name already exists";
	}
	
	

}
