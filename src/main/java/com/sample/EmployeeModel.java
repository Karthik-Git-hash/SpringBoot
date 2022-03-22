package com.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "employee2")
@Table(name = "employee2")
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EID")
	private Integer EmpID;
	
	@Column(name = "ENAME")
	private String EmpName;
	
	@Column(name = "EAGE")
	private int EmpAge;
	
	
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public EmployeeModel(Integer empID, String empName, int empAge) {
		super();
		EmpID = empID;
		EmpName = empName;
		EmpAge = empAge;
	}




	public Integer getEmpID() {
		return EmpID;
	}


	public void setEmpID(Integer empID) {
		EmpID = empID;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public int getEmpAge() {
		return EmpAge;
	}


	public void setEmpAge(int empAge) {
		EmpAge = empAge;
	}
	
	
}
