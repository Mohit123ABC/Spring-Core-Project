package com.rays.autowire.NoType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoiwreNoType {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-No-Type.xml");
		
		 UserService userService =(UserService) context.getBean("userService");
		 
		 userService.testAdd();
	}

}
