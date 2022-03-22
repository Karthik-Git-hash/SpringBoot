package com.sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer>{
	
	//JPQL query
	//@Query("SELECT ep from employee2 ep where ep.EmpAge=?1")
	//public List<EmployeeModel> getUserByAge(int age);
	
	
	//Native query
	@Query(value="SELECT * from employee2 ep where ep.EAGE=?1",nativeQuery = true)
	public List<EmployeeModel> getUserByAge(int age);


}
