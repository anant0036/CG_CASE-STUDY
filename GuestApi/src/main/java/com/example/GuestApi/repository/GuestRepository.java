package com.example.GuestApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.GuestApi.model.Guest;
import java.util.Optional;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String>{

	@Query("{'name': ?0}")
	Optional<Guest> findByName(String name);

	
	
}
