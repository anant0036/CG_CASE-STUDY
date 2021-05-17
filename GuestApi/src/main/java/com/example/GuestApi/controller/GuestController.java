package com.example.GuestApi.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GuestApi.exception.GuestCollectionException;
import com.example.GuestApi.model.Guest;
import com.example.GuestApi.service.GuestService;

@RestController
@RequestMapping("/api")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping("/guest")
	public ResponseEntity<?> getAllGuest()
	{
		List<Guest> guest = guestService.getAllGuest();
		return new ResponseEntity<>(guest, guest.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/guest")
	public ResponseEntity<?> createGuest(@RequestBody Guest guest)
	{
		try
		{
			guestService.createGuest(guest);
			return new ResponseEntity<Guest>(guest, HttpStatus.OK);
		}
		catch (GuestCollectionException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		catch(ConstraintViolationException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} 

	}

	@GetMapping("guest/{id}")
	public ResponseEntity<?> getSingleGuest(@PathVariable("id") String id)
	{
		try
		{
			return new ResponseEntity<>(guestService.getSingleGuest(id),HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/guest/{id}")
	public ResponseEntity<?> updateGuest(@PathVariable("id") String id, @RequestBody Guest guest)
	{
		try
		{
			guestService.updateGuest(id,guest);
			return new ResponseEntity<>("Guest Detail has been Updated With id "+id,HttpStatus.OK);
		}
		catch (GuestCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch (ConstraintViolationException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping("/guest/{id}")
	public ResponseEntity<?> deleteGuest(@PathVariable("id") String id)
	{
		try
		{
			guestService.deleteGuest(id);
			return new ResponseEntity<>("Guest is deleted!!",HttpStatus.OK);
		}
		catch (GuestCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
