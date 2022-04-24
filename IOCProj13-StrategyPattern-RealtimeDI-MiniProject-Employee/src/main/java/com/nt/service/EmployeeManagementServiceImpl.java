package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeManagementServiceImpl implements IEmployeeManagementService{
	//HAS - A Property
	private IEmployeeDAO dao;

	public EmployeeManagementServiceImpl(IEmployeeDAO dao) {
		System.out.println("EmployeeManagementServiceImpl:: 1-param constructor");
		this.dao = dao;
	}//constructor
	
	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		System.out.println("EmployeeManagementServiceImpl.registerEmployee()");
		//write business logic to calculate gross salary and net salary
		Float grosssalary=dto.getBasicsalary()+dto.getBasicsalary()*0.4f;
		Float netsalary=grosssalary-dto.getBasicsalary()*0.2f;
		
		EmployeeBO empBO=new EmployeeBO(); 
		empBO.setEname(dto.getEname());
		empBO.setEadd(dto.getEadd());
		empBO.setBasicsalary(dto.getBasicsalary());
		empBO.setGrosssalary(grosssalary);
		empBO.setNetsalary(netsalary);
		
		//use DAO
		int count=dao.insert(empBO);
		
		//process the result
		return count==0?" employee Details Insertion Failed":" Employee Inserted Succedded :: Total Net Salary:: "+netsalary;
		
	}//method
	
}//class
