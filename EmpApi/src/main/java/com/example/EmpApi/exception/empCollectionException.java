package com.example.EmpApi.exception;

public class empCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public empCollectionException(String message)
	{
		super(message);
	}
	
	public static String NotFoundException(String id)
	{
		return "Employee with "+id+" not found!";
	}
	
	public static String EmpAlreadyExists()
	{
		return "Employee with given name already exists";
	}

}
