package com.example.reservation.service;

import com.example.reservation.Exception.ResCollectionException;
import com.example.reservation.model.Reservation;
import com.example.reservation.respository.ReservationRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ResServiceImpl implements ResService{

    @Autowired
    private ReservationRespo repo;

    @Override
    public void CreateRes(Reservation res) throws ConstraintViolationException, ResCollectionException {
        Optional<Reservation> ResIsThere = repo.findByName(res.getName());
        if(ResIsThere.isPresent())
        {
            throw new ResCollectionException(ResCollectionException.ResAlreadyExists());
        }
        else
        {          
        	repo.save(res);
        }

    }

    @Override
    public List<Reservation> getAllRes() {
        List<Reservation> AllRes = repo.findAll();
        if(AllRes.size()>0)
        {
            return AllRes;
        }
        else
        {
            return new ArrayList<Reservation>();
        }
    }

    @Override
    public Reservation getSingleRes(String id) throws ResCollectionException {
        Optional<Reservation> res = repo.findById(id);
        if(!res.isPresent())
        {
            throw new ResCollectionException(ResCollectionException.NotFoundException(id));
        }
        else {
            return res.get();
        }
    }

    @Override
    public void updateRes(String id, Reservation res) throws ResCollectionException {
        Optional<Reservation> resWithId = repo.findById(id);

        if(resWithId.isPresent())
        {
            Reservation resToUpdate = resWithId.get();
            resToUpdate.setName(res.getName());
            resToUpdate.setCheckIn(res.getCheckIn());
            resToUpdate.setCheckOut(res.getCheckOut());
            resToUpdate.setNoChild(res.getNoChild());
            resToUpdate.setNoAdult(res.getNoAdult());
            resToUpdate.setNoNight(res.getNoNight());
            repo.save(resToUpdate);
        }
        else
        {
            throw new ResCollectionException(ResCollectionException.NotFoundException(id));
        }

    }

    @Override
    public void deleteRes(String id) throws ResCollectionException {
        Optional<Reservation> res = repo.findById(id);
        if(!res.isPresent())
        {
            throw new ResCollectionException(ResCollectionException.NotFoundException(id));
        }
        else {
            repo.deleteById(id);
        }
    }

}
