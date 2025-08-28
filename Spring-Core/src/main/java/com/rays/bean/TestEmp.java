package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Emp.xml");
		
		 Emp emp =(Emp) context.getBean("emp");
		 System.out.println(emp.getName());
		 System.out.println(emp.getLastName());
		 System.out.println(emp.getAddress());
	}

}
