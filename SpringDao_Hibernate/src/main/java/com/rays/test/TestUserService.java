package com.rays.test;

import java.util.Iterator;
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
	public UserServiceInt servcie = null;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		 TestUserService test =(TestUserService) context.getBean("testUserService");
		 
		// test.testAdd();
		// test.testUpdate();
		// test.testFindByPk();
		// test.testdelete();
		// test.testSearch();
		 test.testAuth();
	}
	
	public void testAdd() {
		UserDTO dto = new UserDTO();
		//dto.setId(4);
		dto.setFirstName("mohit");
		dto.setLastName("Gayke");
		dto.setLogin("mohit@gmail.com");
		dto.setPassword("mohit@123");
		long pk = servcie.add(dto);
		System.out.println("data added=pk"+pk);
	}
	
	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Muskan");
		dto.setLastName("Patel");
		dto.setLogin("muskan@gmail.com");
		dto.setPassword("muskan@123");
		servcie.update(dto);
		System.out.println("data update");
	}
	
	public void testFindByPk() {
		 UserDTO dto = servcie.findByPK(2);
		 if(dto != null) {
			 System.out.print(dto.getId());
				System.out.print("\t" + dto.getFirstName());
				System.out.print("\t" + dto.getLastName());
				System.out.print("\t" + dto.getLogin());
				System.out.println("\t" + dto.getPassword());
		 }else {
			 System.out.println("not exist");
		 }
	}
	
	public void testdelete() {
		UserDTO dto = new UserDTO();
		servcie.delete(2);
		System.out.println("data deleted");
	}
	
	public void testSearch() {
		UserDTO dto = new UserDTO();
		System.out.println("service"+servcie);
		List<UserDTO> l = servcie.search(dto, 1, 5);
		
		Iterator it = l.iterator();
		
		while(it.hasNext()) {
			 dto =(UserDTO) it.next();
			 System.out.print(dto.getId());
				System.out.print("\t" + dto.getFirstName());
				System.out.print("\t" + dto.getLastName());
				System.out.print("\t" + dto.getLogin());
				System.out.println("\t" + dto.getPassword());
		}
	}
	
	public void testAuth() {
		 UserDTO dto = servcie.authenticate("purab@gmail.com", "purab@123");
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

}
