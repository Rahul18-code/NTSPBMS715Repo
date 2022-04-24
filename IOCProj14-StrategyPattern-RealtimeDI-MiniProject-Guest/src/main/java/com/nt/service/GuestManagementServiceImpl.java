package com.nt.service;

import com.nt.bo.GuestBO;
import com.nt.dao.IGuestDAO;
import com.nt.dto.GuestDTO;

public class GuestManagementServiceImpl  implements IGuestManagementService{
	//HAS -A Property 
	private IGuestDAO dao;

	public GuestManagementServiceImpl(IGuestDAO dao) {
		System.out.println("GuestManagementServiceImpl::1-param constructor");
		this.dao = dao;
	}//constructor
	
	@Override
	public String registerGuest(GuestDTO dto) throws Exception {
		System.out.println("GuestManagementServiceImpl.registerGuest()");
		//write business logic to calculate bill amount
		double bill=(dto.getPdaycharge()*dto.getDaysstayed());
		//prepare pguest class obj having persistable data
		GuestBO guestBO=new GuestBO();
		guestBO.setGname(dto.getGname());
		guestBO.setGadd(dto.getGadd());
		guestBO.setPdaycharge(dto.getPdaycharge());
		guestBO.setDaysstayed(dto.getDaysstayed());
		guestBO.setBill(bill);
		
		//use DAO
		int count=dao.insert(guestBO);
		
		//process the result
		return count==0?" Guest Details Insertion Failed":" Guest Inserted Succedded :: Total Bill Amount:: "+bill;
	}//method
	
}//class
