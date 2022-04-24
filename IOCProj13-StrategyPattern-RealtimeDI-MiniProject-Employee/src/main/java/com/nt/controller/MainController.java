package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeManagementService;
import com.nt.vo.EmployeeVO;

public class MainController {
	//HAS - A Property
	private IEmployeeManagementService service;

	public MainController(IEmployeeManagementService service) {
		System.out.println("MainController:: 1-param constructor");
		this.service = service;
	}
	
	public String processEmployee(EmployeeVO vo)throws Exception{
		//convert VO class obj to DTO class obj
		EmployeeDTO empDTO=new EmployeeDTO();
		empDTO.setEname(vo.getEname());
		empDTO.setEadd(vo.getEadd());
		empDTO.setBasicsalary(Float.parseFloat(vo.getBasicsalary()));
	//	empDTO.setGrosssalary(Float.parseFloat(vo.getGrosssalary()));
	//	empDTO.setNetsalary(Float.parseFloat(vo.getNetsalary()));
		String resultMsg=service.registerEmployee(empDTO);
		return resultMsg;
	}//method
	
}//class
