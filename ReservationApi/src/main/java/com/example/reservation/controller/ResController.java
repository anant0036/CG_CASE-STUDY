package com.example.reservation.controller;
import javax.validation.ConstraintViolationException;
import com.example.reservation.Exception.ResCollectionException;
import com.example.reservation.model.Reservation;
import com.example.reservation.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResController {

    @Autowired
    private ResService service;

    @PostMapping("/res")
    public ResponseEntity<?> createRes(@RequestBody Reservation res)
    {
        try
        {
            service.CreateRes(res);
            return new ResponseEntity<Reservation>(res, HttpStatus.OK);
        } catch (ResCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (ConstraintViolationException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/res")
    public ResponseEntity<?> getAllRes()
    {
        List<Reservation> res = service.getAllRes();
        return new ResponseEntity<>(res, res.size()>0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("res/{id}")
    public ResponseEntity<?> getSingleRes(@PathVariable("id") String id)
    {
        try
        {
            return new ResponseEntity<>(service.getSingleRes(id), HttpStatus.OK);
        }
        catch(Exception  e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/res/{id}")
    public ResponseEntity<?> updateRes(@PathVariable("id") String id, @RequestBody Reservation res)
    {
        try{
            service.updateRes(id,res);
            return new ResponseEntity<>("Updated !!", HttpStatus.OK);
        }
        catch (ConstraintViolationException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (ResCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/res/{id}")
    public ResponseEntity<?> deleteRes(@PathVariable("id") String id)
    {
        try
        {
            service.deleteRes(id);
            return new ResponseEntity<>("Successfully deleted the Record",HttpStatus.OK);
        }
        catch (ResCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
