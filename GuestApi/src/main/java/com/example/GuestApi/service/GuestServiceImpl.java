package com.example.GuestApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GuestApi.exception.GuestCollectionException;
import com.example.GuestApi.model.Guest;
import com.example.GuestApi.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository repo;
	
	
	@Override
	public List<Guest> getAllGuest() 
	{
		List<Guest> allGuest = repo.findAll();
		if(allGuest.size()>0)
		{
			return allGuest;
		}
		else
		{
			return new ArrayList<Guest>();
		}
	}


	@Override
	public void createGuest(Guest guest) throws ConstraintViolationException,GuestCollectionException {
		
		Optional<Guest> addGuest = repo.findByName(guest.getName());
		if(addGuest.isPresent())
		{
			throw new GuestCollectionException(GuestCollectionException.GuestAlreadyExists());
		}
		else
		{
			repo.save(guest);
		}
		
	}

	@Override
	public Guest getSingleGuest(String id) throws GuestCollectionException {
		Optional<Guest> guest = repo.findById(id);
		if(guest.isPresent())
		{
			return guest.get();

		}
		else
		{
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		}
	}

	@Override
	public void updateGuest(String id, Guest guest) throws GuestCollectionException {

		Optional<Guest> guestWithId = repo.findById(id);

		if(guestWithId.isPresent())
		{
			Guest guestToUpdate = guestWithId.get();
			guestToUpdate.setName(guest.getName());
			guestToUpdate.setAddress(guest.getAddress());
			guestToUpdate.setEmail(guest.getEmail());
			guestToUpdate.setPhonenumber(guest.getPhonenumber());
			guestToUpdate.setGender(guest.getGender());
			guestToUpdate.setGovId(guest.getGovId());
			repo.save(guestToUpdate);
		}
		else
		{
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		}

	}

	@Override
	public void deleteGuest(String id) throws GuestCollectionException {
		Optional<Guest> guestToDelete = repo.findById(id);

		if(!guestToDelete.isPresent())
		{
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		}
		else
		{
			repo.deleteById(id);
		}

	}

}
