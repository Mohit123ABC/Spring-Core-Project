package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {
	
	@Autowired
	private UserDAOInt dao = null;

	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		long pk = dao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
		
	}

	public UserDTO delete(long id) {
		// TODO Auto-generated method stub
		 UserDTO deleteUser = dao.delete(id);
		return deleteUser;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		
		return dao.findByLogin(login);
	}

	public UserDTO auth(String login, String password) {
		// TODO Auto-generated method stub
		UserDTO user  =dao.auth(login, password);
		return user;
	}

	public UserDTO findByPk(long pk) {
		// TODO Auto-generated method stub
		return dao.findByPk(pk);
	}

	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

}
