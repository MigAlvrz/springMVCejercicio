package com.capgemini.persistance;

import java.util.List;

import com.capgemini.model.User;

public interface UserDao {
	
	public void add(User user);
	public User findUser(Long id);
	public List<User> getUsers();
}
