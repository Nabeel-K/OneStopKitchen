/**
 * 
 */
package com.kitchenworld.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.User;

/**
 * @author CTStudent
 *
 */
class TestUserService {
	private static UserService us = null;
	private User testUser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		us = new UserService();
		us.connect();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		us.closeConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 testUser = new User("12345 Help Street","Boonies","USA", "pef@hef.com", "Gary", "Oak", "Rhode Island","02930");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testUser = null;
	}

	@Test
	void testFindUserById() {
		us.addUser(testUser);
		User expected = testUser;
		
		//Get list of users to get size
		List<User> allUsers = us.findAllUsers();
		User actual = us.findUserById(allUsers.size());
		
		assertEquals(expected, actual);
	}

}
