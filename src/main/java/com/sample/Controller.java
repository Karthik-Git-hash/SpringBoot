package com.sample;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Controller {
	
	@Autowired
	private EmployeeService esp;
	
	@GetMapping
	public List<EmployeeModel> getAll()
	{
		return esp.getAll(); 
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeModel> getById(@PathVariable int id)
	{
		try {
			EmployeeModel emp = esp.getById(id);
			return new ResponseEntity<EmployeeModel>(emp,HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<EmployeeModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/age/{id}")
	public ResponseEntity<List<EmployeeModel>> getDetailsByAge(@PathVariable int id)
	{
		try {
			return new ResponseEntity<>(esp.getDetailsByAge(id),HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void add(@RequestBody EmployeeModel emp)
	{
		esp.save(emp);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeModel> update(@RequestBody EmployeeModel ep,@PathVariable int id)
	{
		try {
			EmployeeModel emp = esp.getById(id);
			if(emp.getEmpID()== id) {
			  esp.save(ep);
			  return new ResponseEntity<EmployeeModel>(ep,HttpStatus.OK);
			}	
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<EmployeeModel>(HttpStatus.NOT_FOUND);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		esp.delete(id);
		
	}
	
	

}
