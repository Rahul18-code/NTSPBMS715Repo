package com.nt.controller;

import com.nt.dto.PatientDTO;
import com.nt.service.IPatientManagementService;
import com.nt.vo.PatientVO;

public class MainController {
	//has a property 
	private IPatientManagementService service;

	public MainController(IPatientManagementService service) {
		System.out.println("MainController:: 1-param constructor");
		this.service = service;
	}
	
	public String processPatient(PatientVO vo)throws Exception{
		//convert VO class obj to DTO class obj
		PatientDTO patDTO=new PatientDTO();
		patDTO.setPname(vo.getPname());
		patDTO.setPadd(vo.getPadd());
		patDTO.setPdaycharge(Double.parseDouble(vo.getPdaycharge()));
		patDTO.setTime(Double.parseDouble(vo.getTime()));
		//patDTO.setBill(Double.parseDouble(vo.getBill()));
		//use Service 
		String resultMsg=service.registerPatient(patDTO);
		return resultMsg;
	}
	
}
