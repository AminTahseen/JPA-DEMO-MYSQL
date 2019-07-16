package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;

@Repository
public class UserRepository {
		 
		private static final Logger LOGGER = Logger.getLogger("UserRepository");

	@Autowired
	JdbcTemplate temp;
	
	public List<Map<String, Object>> getAllUsers() {
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		String sql="SELECT * FROM users";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		data = temp.queryForList(sql);
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return data;	
	}
	public int getCount() {
		String sql="SELECT count(*) FROM users";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		Integer totalRecords =temp.queryForObject(sql, int.class);
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return totalRecords;
	}
	public int addUser(UserModel us) {
		String sql="INSERT INTO users VALUES(?,?,?)";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		int status= temp.update(sql,us.getUser_id(),us.getUser_name(),us.getUser_job());
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return status;
	}
	public int deleteUser(String uname) {
		String sql="DELETE FROM users WHERE user_name=?";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		int status= temp.update(sql,uname);
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return status;
	}
	public int UpdateUser(UserModel us) {
		String sql="UPDATE users SET user_job=? WHERE user_name=?";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		int status= temp.update(sql,us.getUser_job(),us.getUser_name());
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return status;
	}
	public UserModel getUser(String uname) {
		String sql="SELECT * FROM users WHERE user_name='"+uname+"'";
		LOGGER.log(Level.SEVERE, "Created query [ " + sql +  "]");
		UserModel us=temp.queryForObject(sql, new BeanPropertyRowMapper<>(UserModel.class));
		LOGGER.log(Level.SEVERE, "Executed query [ " + sql +  "]");
		return us;
	}
}
