package com.nt.service;

import com.nt.bo.PatientBO;
import com.nt.dao.IPatientDAO;
import com.nt.dto.PatientDTO;

public class PatientManagementService implements IPatientManagementService{
	//has a property 
	private IPatientDAO dao;

	public PatientManagementService(IPatientDAO dao) {
		System.out.println("PatientManagementService:: 1-param constructor");
		this.dao = dao;
	}//constructor
	
	@Override
	public String registerPatient(PatientDTO dto) throws Exception {
		System.out.println("PatientManagementService.registerPatient()");
		//write b.logic to calculate bill amount
		double bill=(dto.getPdaycharge()*dto.getTime());
		//preapre Patient class obj having persistable data
		PatientBO patBO=new PatientBO();
		patBO.setPname(dto.getPname());
		patBO.setPadd(dto.getPadd());
		patBO.setPdaycharge(dto.getPdaycharge());
		patBO.setBill(bill);
		
		//use DAO
		int count=dao.insert(patBO);
		//process the result
		return count==0?"Patient Details Insertion Failed":" Patient Inserted Succedded :: Bill Amount:: "+bill;
	}
}
