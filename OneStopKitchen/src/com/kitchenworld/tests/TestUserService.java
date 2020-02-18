/**
 * TestUserService.java
 * DESC - test cases that test the functions defined in UserService.java using mock data
 */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.User;
import com.kitchenworld.services.UserService;

/**
 * @author Nabeel
 *
 */
class TestUserService {

	 User testUser;
	 static UserService us = new UserService();

	 @BeforeAll
	 static void setUpBeforeClass() throws Exception{
		 us.connect();
	 }
	 
	 @AfterAll
	static void tearDownAfterClass() throws Exception{
		 us.closeConnection();
	 }
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testUser=null;
	}

	@Test
	void testAddUser() {
		User expectedUser = testUser;
		us.addUser(expectedUser);
		
		assertEquals(expectedUser, us.findUserById(expectedUser.getUserId()));
		
	}
	
//	@Test
//	void testRemoveUser() {
//		us.deleteUser(testUser.getUserId());
//		assertTrue(!us.findAllUsers().contains(testUser));
//	}

}
