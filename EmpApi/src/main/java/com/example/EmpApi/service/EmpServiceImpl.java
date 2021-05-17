package com.example.EmpApi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmpApi.exception.empCollectionException;
import com.example.EmpApi.model.Employee;
import com.example.EmpApi.repository.EmpRespository;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRespository repo;

	@Override
	public void createEmp(Employee emp) throws ConstraintViolationException,empCollectionException {
		Optional<Employee> addemp = repo.findByName(emp.getName());
		if(addemp.isPresent())
		{
			throw new empCollectionException(empCollectionException.EmpAlreadyExists());
		}
		else
		{
			repo.save(emp);
		}
		
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> Allemp = repo.findAll();
		if(Allemp.size() > 0)
		{
			return Allemp;
		}
		else
		{
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee getSingleEmp(String id) throws empCollectionException {
		
		Optional<Employee> emp = repo.findById(id);
		if(!emp.isPresent())
		{
			throw new empCollectionException(empCollectionException.NotFoundException(id));
		}
		else
		{
			return emp.get();
		}
		
	}

	@Override
	public void updateEmp(String id, Employee emp) throws empCollectionException {
		
		Optional<Employee> empwithid = repo.findById(id);
		//Optional<Employee> empwithSameName = repo.findByName(emp.getName());
		
		if(empwithid.isPresent())
		{
			
//			if(empwithid.isPresent() && !empwithSameName.get().getId().equals(empwithid.get().getId());
//			{
//				throw new empCollectionException(empCollectionException.EmpAlreadyExists());
//			}
			
			Employee empToUpdate = empwithid.get();
			empToUpdate.setName(emp.getName());
			empToUpdate.setEmail(emp.getEmail());
			empToUpdate.setAddress(emp.getAddress());
			empToUpdate.setSalary(emp.getSalary());
			empToUpdate.setAge(emp.getAge());
			repo.save(empToUpdate);
			
		}
		else
		{
			throw new empCollectionException(empCollectionException.NotFoundException(id));
		}
		
		
		
	}

	@Override
	public void deleteEmpById(String id) throws empCollectionException {
		Optional<Employee> emp = repo.findById(id);
		if(!emp.isPresent())
		{
			throw new empCollectionException(empCollectionException.NotFoundException(id));
		}
		else
		{
			repo.deleteById(id);
		}
		
	}
	
}
