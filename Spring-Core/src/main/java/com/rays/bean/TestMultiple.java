package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Multiple.xml");
		
		    Emp emp =(Emp) context.getBean("emp");
		    
		 Person person =(Person) context.getBean("person");
		 
		 System.out.println("Emp name :"+emp.getName());
		 System.out.println("emp lastname :"+emp.getLastName());
		 System.out.println("emp address :"+emp.getAddress());
		 
		 System.out.println("Person name :"+person.getName());
		 System.out.println("person city :"+person.getCity());
	}

}
