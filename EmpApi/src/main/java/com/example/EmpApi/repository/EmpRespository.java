package com.example.EmpApi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EmpApi.model.Employee;

@Repository
public interface EmpRespository extends MongoRepository<Employee, Integer> {

	Optional<Employee> findById(String id);

	void deleteById(String id);
	
	@Query("{'name': ?0}")
	Optional<Employee> findByName(String name);
	

}
