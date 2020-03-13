/**
 * Filename: TestUserService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.kitchenworld.entity.User;
import com.kitchenworld.services.UserService;

/**
 * @author Nabeel
 *
 */
class TestUserService {
	 UserService us;
	 User testUser;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 us = new UserService();
		 testUser = new User("test@test.com",BCrypt.hashpw("testpass", BCrypt.gensalt()),"John","Doe");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		 us.closeConnection();
	}

	@Test
	void testAddUser() {
		User expectedUser = testUser;
		us.addUser(expectedUser);
		
		assertEquals(expectedUser, us.findUserById(expectedUser.getUserId()));
		//delete to avoid duplicate email entries
		us.deleteUser(testUser);
	}
	
	@Test
	void testRemoveUser() {
		//given
		us.addUser(testUser);
		//when
		us.deleteUser(testUser);
		assertTrue(!us.findAllUsers().contains(testUser));
	}
	
	@Test
	void testLoginMatch() {
		//given
		us.addUser(testUser);
		//when
		User authUser = us.loginMatch("test@test.com", "testpass");
		
		assertNotNull(authUser,"correct user should have been found");
		assertEquals(testUser.getEmail(), authUser.getEmail(),"Unique email of the authenticate user should match the added testUser");
		//delete to avoid duplicate email entries
		us.deleteUser(testUser);
	}
	
	@Test
	void testInvalidLoginMatch() {
		//given
		us.addUser(testUser);
		//when
		User authUser = us.loginMatch("test@test.com", "wrongpass");
		
		assertNull(authUser,"incorrect password should not return a user");
		//delete to avoid duplicate email entries
		us.deleteUser(testUser);
	}
	
	@Test
	void testFindAllUsers() {
		//given		
		User testUser1 = new User("test1@test.com",BCrypt.hashpw("testpass", BCrypt.gensalt()),"John","Doe");
		User testUser2 = new User("test2@test.com",BCrypt.hashpw("testpass", BCrypt.gensalt()),"John","Doe");
		User testUser3 = new User("test3@test.com",BCrypt.hashpw("testpass", BCrypt.gensalt()),"John","Doe");

		us.addUser(testUser1);
		us.addUser(testUser2);
		us.addUser(testUser3);
		
		//When
		List<User> actualUsers = us.findAllUsers();
		
		assertTrue(actualUsers.contains(testUser1), "Users added should be retrieved in find all");
		assertTrue(actualUsers.contains(testUser2), "Users added should be retrieved in find all");
		assertTrue(actualUsers.contains(testUser3), "Users added should be retrieved in find all");
		//delete to avoid duplicate email entries
		us.deleteUser(testUser1);
		us.deleteUser(testUser2);
		us.deleteUser(testUser3);
		us.deleteUser(testUser);
	}
	
	@Test
	void testFindById(){
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();
		//when
		User actualUser = us.findUserById(idToTest);
		assertTrue(actualUser.equals(testUser),"The user retrieved should match the user added");
		//delete to avoid duplicate email entries
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdateFirstName() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newName="testName";
		us.updateUserFirstName(idToTest, newName);
		assertTrue(testUser.getFirstName().equals(newName),"The updated order should have a new first name");
		
		us.deleteUser(testUser);
	}
	
	
	@Test
	void testUpdateLastName() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newName="testName";
		us.updateUserLastName(idToTest, newName);
		assertTrue(testUser.getLastName().equals(newName),"The updated user should have a new last name");
		
		us.deleteUser(testUser);
	}

	
	@Test
	void testUpdateEmail() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newEmail="new@test.com";
		us.updateUserEmail(idToTest, newEmail);
		assertTrue(testUser.getEmail().equals(newEmail),"The updated user should have a new email");
		
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdatePassword() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();
		//when
		String newPass=BCrypt.hashpw("mynewpass", BCrypt.gensalt());
		us.updateUserPassword(idToTest, newPass);
		assertTrue(BCrypt.checkpw("mynewpass", testUser.getPassword()),"The updated user should have a valid new password");
		
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdateAddress() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newAddress="1234 Street";
		us.updateUserAddress(idToTest, newAddress);
		assertTrue(testUser.getAddress().equals(newAddress),"The updated user should have a new address");
		
		us.deleteUser(testUser);
	}@Test
	
	void testUpdateCity() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newCity="Five City";
		us.updateUserCity(idToTest, newCity);
		assertTrue(testUser.getCity().equals(newCity),"The updated user should have a new city");
		
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdateState() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newState="MI";
		us.updateUserState(idToTest, newState);
		assertTrue(testUser.getState().equals(newState),"The updated user should have a new state");
		
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdateCountry() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newCountry="USA";
		us.updateUserCountry(idToTest, newCountry);
		assertTrue(testUser.getCountry().equals(newCountry),"The updated user should have a new country code");
		
		us.deleteUser(testUser);
	}
	
	@Test
	void testUpdateZipCode() {
		//given
		us.addUser(testUser);
		long idToTest = testUser.getUserId();

		//when
		String newZip="12344";
		us.updateUserZipCode(idToTest, newZip);
		assertTrue(testUser.getZipcode().equals(newZip),"The updated user should have a new zip code");
		
		us.deleteUser(testUser);
	}
	
}
