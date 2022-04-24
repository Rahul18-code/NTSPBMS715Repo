package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.GuestVO;

public class GuestDI {
	public static void main(String[] args) {
		//read input from enduser as String value
		Scanner scn=new Scanner(System.in);
		String name=null,addrs=null,daycharge=null,days=null;
		if(scn!=null) {
			System.out.print("Enter Guest Name : ");
			name=scn.next();
			System.out.print("Enter Guest Address : ");
			addrs=scn.next();
			System.out.print("Enter Per day Charges : ");
			daycharge=scn.next();
			System.out.print("Enter No Of Days Guest Stayed : ");
			days=scn.next();
		}
		//prepare VO class Obj having inputs
		GuestVO vo=new GuestVO();
		vo.setGname(name);
		vo.setGadd(addrs);
		vo.setPdaycharge(daycharge);
		vo.setDaysstayed(days);
		
		//create IOC container 
		DefaultListableBeanFactory  factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class obj
		MainController controller=factory.getBean("controller",MainController.class);
		try {
			//invoke bussiness method
			String resultMsg=controller.processGuest(vo);
			System.out.println(resultMsg);
		}//try
		catch(Exception e) {
			System.out.println("Problem In Insertion Of Guest :: "+e.getMessage());
			e.printStackTrace();
		}//catvh
	}//main method
}//class
