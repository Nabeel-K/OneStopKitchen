/**
 * QueryRunner.java
 * Desc - Test class to test the functions of query services after the populator has been run
 */
package com.kitchenworld.drivers;

import java.util.List;

import com.kitchenworld.entity.User;
import com.kitchenworld.services.*;

/**
 * @author CTStudent
 *
 */
public class QueryRunner {

	private UserService us;

	public QueryRunner() {
		us = new UserService();
	}

	public static void main(String[] args) {
		QueryRunner qr = new QueryRunner();
		qr.run();
		qr.close();
	}

	private void run() {
		us.connect();

		int testUserId = 2;

		System.out.println("USERS");
		List<User> allUsers = us.findAllUsers();
		User foundUser = us.findUserById(testUserId);
		for (User user : allUsers) {
			System.out.println(user);
		}
		System.out.println("User testUserId is " + foundUser.getFirstName() + " " + foundUser.getLastName()
				+ " and he lives in " + foundUser.getCity());

		us.updateUserCity(testUserId, "London");
		us.updateUserAddress(testUserId, "12345 Help Street");
		us.updateUserState(testUserId, "Texas");
		us.updateUserCountry(testUserId, "USA");
		us.updateUserZipCode(testUserId, "71293");
		us.updateUserFirstName(testUserId, "Nabeel");
		us.updateUserLastName(testUserId, "Terminatus");
		us.updateUserEmail(testUserId, "oijfs@nonsense.com");

		foundUser = us.findUserById(testUserId);
		System.out.println(foundUser);
		
	}

	private void close() {
		us.closeConnection();
	}
}
