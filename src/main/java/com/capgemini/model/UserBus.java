package com.capgemini.model;

public class UserBus {
	private static boolean userAvailable = false;
	private static User user;
	
	public static boolean isUserAvailable() {
		return userAvailable;
	}
	
	public static void setUser(User user) {
		UserBus.user = user;
		userAvailable = true;
	}
	
	public static User getUser() {
		userAvailable = true;
		return user;
	}
}
