package com.capgemini.model;

/**
 * This was my sloppy idea to move the active user around.
 *  The class picks a user and carries it between controllers, 
 *  making it easier for them to know wich user is active 
 *  without having to constantly check out the DB or even
 *  having to tell each other. I called it "bus" because 
 *  it carries an user around different places, like
 *  an actual bus.
 *  
 *  Yes. Using session or any other form of cache would probably
 *  been easier and more convenient. 
 *  
 * @author migualva
 *
 */

public class UserBus {
	private static boolean userAvailable = false;
	private static User user;
	
	/**
	 * Checks if there is an active user
	 * @return
	 */
	public static boolean isUserAvailable() {
		return userAvailable;
	}
	

	/**
	 * Sets an user as the active user
	 * @param user
	 */
	
	public static void setUser(User user) {
		UserBus.user = user;
		userAvailable = true;
	}
	
	
	/**
	 * Gets the active user
	 * @return
	 */
	
	public static User getUser() {
		userAvailable = true;
		return user;
	}
}
