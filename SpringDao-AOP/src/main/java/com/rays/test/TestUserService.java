package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {
	
	public static ApplicationContext context = null;
	
	@Autowired
	public UserServiceInt service = null;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
	    TestUserService test =(TestUserService) context.getBean("testUserService");
	    
	   // test.testAdd();
	  // test.testupdate();
	    test.testAuth();
	}
	
	public void testAdd() {
		
		UserDTO dto = new UserDTO();
		//dto.setId(2);
		dto.setFirstName("Muskan");
		dto.setLastName("Patel");
		dto.setLogin("muskan@gmail.com");
		dto.setPassword("muskan@123");
		long pk = service.add(dto);
		System.out.println("pk=>"+pk);
		
		
	}
	
	public void testupdate() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Pawan");
		dto.setLastName("Gayke");
		dto.setLogin("pawan@gmail.com");
		dto.setPassword("pawan@123");
		service.update(dto);
		System.out.println("Record Updated");
	}
	
	public void testAuth() {
		UserDTO dto = service.auth("mohit@gmail.com", "mohit@123");
		
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	
	}	
	
	public void search() {
		UserDTO dto = new UserDTO();
		System.out.println("service=>"+service);
		List<UserDTO> l = service.search(dto, 1, 5);
		l.forEach(e -> {
			System.out.print(e.getId());
			System.out.print("\t" + e.getFirstName());
			System.out.print("\t" + e.getLastName());
			System.out.print("\t" + e.getLogin());
			System.out.println("\t" + e.getPassword());
		});
	}

}
