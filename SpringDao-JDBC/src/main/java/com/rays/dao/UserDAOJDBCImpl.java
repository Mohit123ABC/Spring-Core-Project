package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(?,?,?,?,?)";
		
		int pk = jdbcTemplate.update(sql,dto.getId(),dto.getFirstName(),dto.getLastName(),
				              dto.getLogin(),dto.getPassword());
		return pk;
	}

	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		String sql = "update user set firstName=?,lastName=?,login=?,password=? where id=?";
		
		int i = jdbcTemplate.update(sql,dto.getFirstName(),dto.getLastName(),dto.getLogin(),
				     dto.getPassword(),dto.getId());
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=?";
		Object[] parms = {id};
		int i = jdbcTemplate.update(sql,parms);
		
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		String sql = "select *from user where login=?";
		Object[] parms = {login};
		 UserDTO user = jdbcTemplate.queryForObject(sql, parms,new UserMapper());
		return user;
	}

	public UserDTO findByPk(long pk) {
		// TODO Auto-generated method stub
		String sql = "select *from user where id=?";
		Object[] parms = {pk};
		List list = jdbcTemplate.query(sql, parms,new UserMapper());
		
		UserDTO dto = null;
		
		if(list.size()>0) {
		dto = (UserDTO)	list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		try {
			String sql = "select *from user where login=? and password=?";
			Object[] parms = {login,password};
			UserDTO user = jdbcTemplate.queryForObject(sql, parms,new UserMapper());
			return user;
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		String sql = "select *from user";
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select *from user where 1=1";
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

}
