package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.PatientVO;

public class PatientDI {
	public static void main(String[] args) {
		//read inputd from enduser as string value
		Scanner scn=new Scanner(System.in);
		String name=null,addrs=null,daycharge=null,time=null;
		if(scn!=null) {
			System.out.print("Enter Patient Name : ");
			name=scn.next();
			System.out.print("Enter Patient Address : ");
			addrs=scn.next();
			System.out.print("Enter Per Day Charges : ");
			daycharge=scn.next();
			System.out.print("Enter No Of Days Patient Stay : ");
			time=scn.next();
			
		}
		//prepare vo class obj having inputs
		PatientVO vo=new PatientVO();
		vo.setPname(name);
		vo.setPadd(addrs);
		vo.setPdaycharge(daycharge);
		vo.setTime(time);
		//create IOC container
		DefaultListableBeanFactory  factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class obj
		MainController controller=factory.getBean("controller",MainController.class);
		try {
			//invoke business method 
			String resultMsg=controller.processPatient(vo);
			System.out.println(resultMsg);
		}//try
		catch(Exception e) {
			System.out.println("Problem In Insertion Of Patient :: "+e.getMessage());
			e.printStackTrace();
		}//catch
		
	}//main
}//class
