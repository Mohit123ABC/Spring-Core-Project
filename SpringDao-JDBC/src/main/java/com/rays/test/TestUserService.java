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
	
	@Autowired
	public UserServiceInt service = null;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		 TestUserService test =(TestUserService) context.getBean("testUserService");

		// test.testAdd();
		// test.testUpdate();
		// test.testdelete();
		// test.testFindByPk();
		// test.testAuth();
		 test.testSearch();
	}
	
	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("sonu");
		dto.setLastName("patil");
		dto.setLogin("sonu@gmail.com");
		dto.setPassword("sonu@123");
		
		long pk = service.add(dto);
		System.out.println("data inserted=pk"+pk);
	}
	
	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Muskan");
		dto.setLastName("Patel");
		dto.setLogin("muskan@gmail.com");
		dto.setPassword("muskan@123");
		
		service.update(dto);
		System.out.println("data updated");
	}
	
	public void testdelete() {
		UserDTO dto = new UserDTO();
		service.delete(2);
		System.out.println("deleted data");
	}
	
	public void testFindByPk() {
		UserDTO dto = service.findByPk(1);
		if(dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User ID not exist..!!!");
		}
	}
	
	public void testAuth() {
		 UserDTO dto = service.authenticate("mohit@gmail.com", "mohit@123");
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
	
	public void testSearch() {
		UserDTO dto = new UserDTO();
		
		 List<UserDTO> list= service.search(dto, 0, 5);
		 
		 Iterator<UserDTO> it = list.iterator();
		 
		 while(it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		 }
	}

}
