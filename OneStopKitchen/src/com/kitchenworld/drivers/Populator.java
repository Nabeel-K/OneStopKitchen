/**
 * 
 */
package com.kitchenworld.drivers;

import com.kitchenworld.entity.User;
import com.kitchenworld.services.UserService;

/**
 * @author CTStudent
 *
 */
public class Populator {
	private UserService us;
	
	public Populator() {
		us = new UserService();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Populator p = new Populator();
		p.run();
		p.close();
	}
	
	private void run() {
		us.connect();
		User user1 = new User("bob@gold.com", "Bob", "Stevens");
		User user2 = new User("doej@mail.com", "John", "Doe");

		us.addUser(user1);
		us.addUser(user2);
		
		//Find Query
		
	}
	
	private void close() {
		us.closeConnection();
	}

}
