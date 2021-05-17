package com.example.reservation.service;

import com.example.reservation.Exception.ResCollectionException;
import com.example.reservation.model.Reservation;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface ResService  {

    public void CreateRes(Reservation res) throws ConstraintViolationException, ResCollectionException;
    public List<Reservation> getAllRes();
    public Reservation getSingleRes(String id) throws ResCollectionException;
    public void updateRes(String id,Reservation res) throws ResCollectionException;
    public void deleteRes(String id) throws ResCollectionException;

}
