package com.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public List<EmployeeModel> getAll()
	{
		return repo.findAll();
		
	}
	
	public List<EmployeeModel> getDetailsByAge(int age)
	{
		return repo.getUserByAge(age);
		
	}
	
	public void save(EmployeeModel emp)
	{
		repo.save(emp);
		
	}
	
	public EmployeeModel getById(int id)
	{
		return repo.findById(id).get();
		
	}
	
	public void delete(int id)
	{
		repo.deleteById(id);
		
	}
	
}
