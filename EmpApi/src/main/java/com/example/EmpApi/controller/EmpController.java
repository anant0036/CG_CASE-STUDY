package com.example.EmpApi.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmpApi.exception.empCollectionException;
import com.example.EmpApi.model.Employee;
import com.example.EmpApi.service.EmpService;


@RestController()
@CrossOrigin(origins = "http://localhost:4200",  maxAge = 3600)
@RequestMapping("/api")
public class EmpController{
	
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp")
	public ResponseEntity<?> getAllEmp()
	{
		List<Employee> emp = empService.getAllEmp();
		return new ResponseEntity<>(emp, emp.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<?> createEmp(@RequestBody Employee emp)
	{
		try
		{
			empService.createEmp(emp);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		catch(ConstraintViolationException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch(empCollectionException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<?> getSingleEmp(@PathVariable("id") String id)
	{
		
		try
		{
			return new ResponseEntity<>(empService.getSingleEmp(id), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/emp/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Employee emp)
	{
		try
		{
			empService.updateEmp(id, emp);
			return new ResponseEntity<>("Update Employee with id "+id,HttpStatus.OK);
		}
		catch(ConstraintViolationException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch(empCollectionException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id)
	{
		try
		{
			empService.deleteEmpById(id);
			return new ResponseEntity<>("Successfully deleted with id" + id, HttpStatus.OK);
		}
		catch(empCollectionException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
