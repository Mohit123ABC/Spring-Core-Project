package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {
	
public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public UserDTO delete(long pk);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO auth(String login,String password);
	
	public UserDTO findByPk(long pk);
	
	public List search(UserDTO dto);
	
	public List search(UserDTO dto,int pageNo,int pageSize);
	
	

}
