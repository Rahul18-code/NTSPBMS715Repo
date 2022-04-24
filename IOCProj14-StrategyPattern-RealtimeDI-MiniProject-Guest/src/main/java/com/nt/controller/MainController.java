package com.nt.controller;

import com.nt.dto.GuestDTO;
import com.nt.service.IGuestManagementService;
import com.nt.vo.GuestVO;

public class MainController {
	//HAS - A Property 
	private IGuestManagementService service;

	public MainController(IGuestManagementService service) {
		System.out.println("MainController:: 1-param constructor");
		this.service = service;
	}
	public String processGuest(GuestVO vo)throws Exception{
		//convert VO class obj to DTO class obj
		GuestDTO guestDTO=new GuestDTO();
		guestDTO.setGname(vo.getGname());
		guestDTO.setGadd(vo.getGadd());
		guestDTO.setPdaycharge(Double.parseDouble(vo.getPdaycharge()));
		guestDTO.setDaysstayed(Integer.parseInt(vo.getDaysstayed()));
		String resultMsg=service.registerGuest(guestDTO);
		return resultMsg;
	}//method
	
}//class
