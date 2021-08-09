package com.capgemini.persistance;

import java.util.List;

import com.capgemini.model.User;

/**
 * This was a DAO for the user that ended not being used 
 * @author migualva
 *
 */

public interface UserDao {
	
	public void add(User user);
	public User findUser(Long id);
	public List<User> getUsers();
}
