package com.example.reservation.Exception;

public class ResCollectionException extends Exception{

    private static final long serialVersionUID = 1L;

    public ResCollectionException(String message)
    {
        super(message);
    }
    public static String NotFoundException(String id)
    {
        return "No Reservation Found with "+id;
    }
    public static String ResAlreadyExists()
    {
        return "Reservation with given name and id already exists";
    }
    public static String EnterTheName()
    {
        return "Enter the name Please";
    }

}
