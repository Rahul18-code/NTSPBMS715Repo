package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class EmployeeDI {
	public static void main(String[] args) {
		//read input from end user as String value
		Scanner scn = new Scanner(System.in);
		String name=null,add=null,bsalary=null;
		if(scn!=null) {
			System.out.print("Enter Employee Name : ");
			name=scn.next();
			System.out.print("Enter Employee Address : ");
			add=scn.next();
			System.out.print("Enter Employee Basic Salary : ");
			bsalary=scn.next();
		}//main method
		//prepare VO class object having inputs 
		EmployeeVO vo=new EmployeeVO();
		vo.setEname(name); 
		vo.setEadd(add);
		vo.setBasicsalary(bsalary);
		
		//create IOC container 
		DefaultListableBeanFactory  factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class obj
		MainController controller=factory.getBean("controller",MainController.class);
		try {
			//invoke business method
			String resultMsg=controller.processEmployee(vo);
			System.out.println(resultMsg);
		}//try
		catch(Exception e) { 
			System.out.println("Problem In Insertion Of Employee Datails :: "+e.getMessage());
			e.printStackTrace();
		}//catch
	}//method
}//class
