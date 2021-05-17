package com.example.EmpApi.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.example.EmpApi.exception.empCollectionException;
import com.example.EmpApi.model.Employee;

public interface EmpService {

	public void createEmp(Employee emp) throws ConstraintViolationException, empCollectionException;
	
	public List<Employee> getAllEmp();
	
	public Employee getSingleEmp(String id) throws empCollectionException;
	
	public void updateEmp(String id, Employee emp) throws empCollectionException;
	
	public void deleteEmpById(String id) throws empCollectionException;
}
